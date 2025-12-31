package software.aoc.day04.b;

import software.aoc.day04.ForkliftAccess;
import software.aoc.day04.PaperMap;

public final class IterativeRemover {

    private final PaperMap initialMap;

    public IterativeRemover(PaperMap map) {
        this.initialMap = map;
    }

    public long totalRemoved() {
        return getTotal(initialMap, 0);
    }

    private static long getTotal(PaperMap map, long total) {
        long removed;
        do {
            PaperRemover.RemovalResult result = PaperRemover.remove(map, getAccessible(map));
            map = result.newMap;
            removed = result.removed;
            total += removed;
        } while (removed > 0);
        return total;
    }

    private static boolean[][] getAccessible(PaperMap map) {
        return new ForkliftAccess(map).accessibleMap();
    }
}
