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

        long removed = IntStream.range(0, map.rows())
                .mapToLong(r -> IntStream.range(0, map.cols())
                        .filter(c -> accessible[r][c])
                        .map(c -> {
                            StringBuilder sb = new StringBuilder(newGrid.get(r));
                            sb.setCharAt(c, '.');
                            newGrid.set(r, sb.toString());
                            return 1;
                        }).sum()
                ).sum();

        return new RemovalResult(new PaperMap(newGrid), removed);
    }
}
