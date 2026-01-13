package software.aoc.day04.model;

import java.util.List;

public record PaperMap(List<String> grid) {

    public boolean isRoll(int row, int col) {
        return grid.get(row).charAt(col) == '@';
    }

    public int rows() {
        return grid.size();
    }

    public int cols() {
        return grid.get(0).length();
    }
}
