package software.aoc.day03;

import java.util.List;
import java.util.stream.IntStream;

public final class MaxJoltageCalculator {

    private final List<Integer> cells;
    private final int selectCount;

    private MaxJoltageCalculator(List<Integer> cells, int selectCount) {
        this.cells = cells;
        this.selectCount = selectCount;
    }

    public static MaxJoltageCalculator from(List<Integer> cells, int selectCount) {
        return new MaxJoltageCalculator(cells, selectCount);
    }

    public long calculate() {
        if (selectCount == 0 || cells.isEmpty()) return 0L;
        return IntStream.range(0, cells.size())
                .mapToLong(this::bestStartingAt)
                .max()
                .orElse(0L);
    }

    private long bestStartingAt(int index) {
        return combine(index, selectCount);
    }

    private long combine(int start, int remaining) {
        if (remaining == 1) return cells.get(start);

        long max = 0L;
        for (int next = start + 1; next < cells.size(); next++) {
            long candidate = cells.get(start) * (long) Math.pow(10, remaining - 1)
                    + combine(next, remaining - 1);
            if (candidate > max) max = candidate;
        }
        return max;
    }
}
