package software.aoc.day12.model;

import java.util.ArrayList;
import java.util.List;

public class Worksheet {

    private final List<Region> regions;
    private final List<Shape> shapes;

    public Worksheet(List<Region> regions, List<Shape> shapes) {
        this.regions = regions;
        this.shapes = shapes;
    }

    public long total() {
        return regions.stream()
                .filter(this::fits)
                .count();
    }

    private boolean fits(Region region) {
        if (calculateTotalShapeArea(region, 0, new ArrayList<>()) > region.area()) return false;
        return canPlaceAllShapes(getBoard(region), new ArrayList<>(), 0);
    }

    private static boolean[][] getBoard(Region region) {
        return new boolean[region.height()][region.width()];
    }

    private int calculateTotalShapeArea(Region region, int totalNeeded, List<Shape> piecesToPlace) {
        for (int i = 0; i < shapes.size(); i++) {
            totalNeeded += region.quantities().get(i) * shapes.get(i).area();
            addPiecesToList(piecesToPlace, region.quantities().get(i), i);
        }
        return totalNeeded;
    }

    private void addPiecesToList(List<Shape> piecesToPlace, int qty, int i) {
        for (int j = 0; j < qty; j++) addSinglePiece(piecesToPlace, i);
    }

    private boolean addSinglePiece(List<Shape> piecesToPlace, int i) {
        return piecesToPlace.add(shapes.get(i));
    }

    private boolean canPlaceAllShapes(boolean[][] board, List<Shape> pieces, int index) {
        if (index == pieces.size()) return true;

        for (Shape variant : pieces.get(index).generateVariants()) {
            for (int r = 0; r <= board.length - variant.getHeight(); r++) {
                for (int c = 0; c <= board[0].length - variant.getWidth(); c++) {
                    if (canPlaceShapeAt(board, variant, r, c)) {
                        setShapeOnBoard(board, variant, r, c, true);
                        if (canPlaceAllShapes(board, pieces, index + 1)) return true;
                        setShapeOnBoard(board, variant, r, c, false);
                    }
                }
            }
        }
        return false;
    }

    private boolean canPlaceShapeAt(boolean[][] board, Shape s, int row, int col) {
        for (int r = 0; r < s.getHeight(); r++) {
            for (int c = 0; c < s.getWidth(); c++) {
                if (s.getAt(r, c) == '#' && board[row + r][col + c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void setShapeOnBoard(boolean[][] board, Shape s, int row, int col, boolean state) {
        for (int r = 0; r < s.getHeight(); r++) {
            for (int c = 0; c < s.getWidth(); c++) {
                if (s.getAt(r, c) == '#') {
                    board[row + r][col + c] = state;
                }
            }
        }
    }
}
