package software.aoc.day12;

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
        if (getTotalNeeded(region, 0, new ArrayList<>()) > region.area()) return false;
        return canPlaceAll(getBoard(region), new ArrayList<>(), 0);
    }

    private static boolean[][] getBoard(Region region) {
        return new boolean[region.height()][region.width()];
    }

    private int getTotalNeeded(Region region, int totalNeeded, List<Shape> piecesToPlace) {
        for (int i = 0; i < shapes.size(); i++) {
            totalNeeded += region.quantities().get(i) * shapes.get(i).area();
            adding_pieces(piecesToPlace, region.quantities().get(i), i);
        }
        return totalNeeded;
    }

    private void adding_pieces(List<Shape> piecesToPlace, int qty, int i) {
        for (int j = 0; j < qty; j++) isAdd(piecesToPlace, i);
    }

    private boolean isAdd(List<Shape> piecesToPlace, int i) {
        return piecesToPlace.add(shapes.get(i));
    }

    private boolean canPlaceAll(boolean[][] board, List<Shape> pieces, int index) {
        if (index == pieces.size()) return true;

        for (Shape variant : pieces.get(index).getAllVariants()) {
            for (int r = 0; r <= board.length - variant.getHeight(); r++) {
                for (int c = 0; c <= board[0].length - variant.getWidth(); c++) {
                    if (isPossible(board, variant, r, c)) {
                        place(board, variant, r, c, true);
                        if (canPlaceAll(board, pieces, index + 1)) return true;
                        place(board, variant, r, c, false);
                    }
                }
            }
        }
        return false;
    }

    private boolean isPossible(boolean[][] board, Shape s, int row, int col) {
        for (int r = 0; r < s.getHeight(); r++) {
            for (int c = 0; c < s.getWidth(); c++) {
                if (s.getAt(r, c) == '#' && board[row + r][col + c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void place(boolean[][] board, Shape s, int row, int col, boolean state) {
        for (int r = 0; r < s.getHeight(); r++) {
            for (int c = 0; c < s.getWidth(); c++) {
                if (s.getAt(r, c) == '#') {
                    board[row + r][col + c] = state;
                }
            }
        }
    }
}
