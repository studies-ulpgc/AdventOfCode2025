package software.aoc.day12;

import java.util.*;

public class Shape {
    private final char[][] grid;

    public Shape(List<String> rows) {
        int r = rows.size();
        int c = rows.get(0).length();
        this.grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            grid[i] = rows.get(i).toCharArray();
        }
    }

    private Shape(char[][] grid) { this.grid = grid; }

    // Genera las 8 variantes posibles (4 rotaciones + sus reflejos)
    public List<Shape> getAllVariants() {
        Set<String> seen = new HashSet<>();
        List<Shape> variants = new ArrayList<>();
        Shape current = this;

        for (int i = 0; i < 4; i++) {
            addIfUnique(current, variants, seen);
            addIfUnique(current.flip(), variants, seen);
            current = current.rotate90();
        }
        return variants;
    }

    private Shape rotate90() {
        int r = grid.length, c = grid[0].length;
        char[][] next = new char[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                next[j][r - 1 - i] = grid[i][j];
        return new Shape(next);
    }

    private Shape flip() {
        int r = grid.length, c = grid[0].length;
        char[][] next = new char[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                next[i][c - 1 - j] = grid[i][j];
        return new Shape(next);
    }

    private void addIfUnique(Shape s, List<Shape> list, Set<String> seen) {
        String representation = Arrays.deepToString(s.grid);
        if (seen.add(representation)) list.add(s);
    }

    // Getters necesarios para el algoritmo
    public int getHeight() { return grid.length; }
    public int getWidth() { return grid[0].length; }
    public char getAt(int r, int c) { return grid[r][c]; }

    public int area() {
        int count = 0;
        for (char[] row : grid)
            for (char c : row) if (c == '#') count++;
        return count;
    }
}