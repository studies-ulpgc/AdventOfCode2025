package software.aoc.day04;

import java.util.stream.IntStream;

public final class ForkliftAccess {

    private final PaperMap map;

    public ForkliftAccess(PaperMap map) {
        this.map = map;
    }

    public long accessibleRolls() {
        return IntStream.range(0, map.rows())
                .mapToLong(r -> IntStream.range(0, map.cols())
                        .filter(c -> map.isRoll(r, c) && isAccessible(r, c))
                        .count())
                .sum();
    }

    private boolean isAccessible(int row, int col) {
        return (int) IntStream.rangeClosed(row - 1, row + 1)
                .flatMap(r -> IntStream.rangeClosed(col - 1, col + 1)
                        .filter(c -> r != row || c != col)
                        .filter(c -> r >= 0 && r < map.rows() && c >= 0 && c < map.cols())
                        .map(c -> map.isRoll(r, c) ? 1 : 0))
                .sum() < 4;
    }

    public boolean[][] accessibleMap() {
        boolean[][] result = new boolean[map.rows()][map.cols()];
        IntStream.range(0, map.rows()).forEach(r ->
                IntStream.range(0, map.cols()).forEach(c ->
                        result[r][c] = map.isRoll(r, c) && isAccessible(r, c)
                )
        );
        return result;
    }
}
