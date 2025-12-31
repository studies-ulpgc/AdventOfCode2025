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
        // 1. Filtro rápido de área (tu lógica actual)
        int totalNeeded = 0;
        List<Shape> piecesToPlace = new ArrayList<>();
        for (int i = 0; i < shapes.size(); i++) {
            int qty = region.quantities().get(i);
            totalNeeded += qty * shapes.get(i).area();
            for (int j = 0; j < qty; j++) piecesToPlace.add(shapes.get(i));
        }
        if (totalNeeded > region.area()) return false;

        // 2. Tablero de juego (false = vacío, true = ocupado)
        boolean[][] board = new boolean[region.height()][region.width()];
        return canPlaceAll(board, piecesToPlace, 0);
    }

    private boolean canPlaceAll(boolean[][] board, List<Shape> pieces, int index) {
        if (index == pieces.size()) return true;

        Shape piece = pieces.get(index);
        for (Shape variant : piece.getAllVariants()) {
            for (int r = 0; r <= board.length - variant.getHeight(); r++) {
                for (int c = 0; c <= board[0].length - variant.getWidth(); c++) {
                    if (isPossible(board, variant, r, c)) {
                        place(board, variant, r, c, true); // Ocupar
                        if (canPlaceAll(board, pieces, index + 1)) return true;
                        place(board, variant, r, c, false); // Liberar (Backtrack)
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
                    return false; // Colisión detectada
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
