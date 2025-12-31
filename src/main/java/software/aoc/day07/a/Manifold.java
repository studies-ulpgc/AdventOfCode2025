package software.aoc.day07.a;

import java.util.List;

public record Manifold(List<String> rows) {

    public static Manifold from(String input) {
        return new Manifold(input.lines().toList());
    }

    public char at(Position p) {
        return rows.get(p.row()).charAt(p.col());
    }

    public boolean contains(Position p) {
        return p.row() >= 0 && p.row() < rows.size()
                && p.col() >= 0 && p.col() < rows.get(0).length();
    }

    public Position start() {
        return find('S');
    }

    private Position find(char c) {
        for (int r = 0; r < rows.size(); r++)
            for (int col = 0; col < rows.get(r).length(); col++)
                if (rows.get(r).charAt(col) == c)
                    return new Position(r, col);
        throw new IllegalStateException("No start");
    }
}
