package software.aoc.day04.b;

import software.aoc.day04.PaperMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class PaperRemover {

    public static class RemovalResult {
        public final PaperMap newMap;
        public final long removed;

        public RemovalResult(PaperMap newMap, long removed) {
            this.newMap = newMap;
            this.removed = removed;
        }
    }

    public static RemovalResult remove(PaperMap map, boolean[][] accessible) {
        List<String> newGrid = new ArrayList<>(map.grid());

        return new RemovalResult(new PaperMap(newGrid), getRemoved(map, accessible, newGrid));
    }

    private static long getRemoved(PaperMap map, boolean[][] accessible, List<String> newGrid) {
        return IntStream.range(0, map.rows())
                .mapToLong(r -> IntStream.range(0, map.cols())
                        .filter(c -> accessible[r][c])
                        .map(c -> extracted(newGrid, r, c)).sum()
                ).sum();
    }

    private static int extracted(List<String> newGrid, int r, int c) {
        StringBuilder sb = new StringBuilder(newGrid.get(r));
        sb.setCharAt(c, '.');
        newGrid.set(r, sb.toString());
        return 1;
    }
}
