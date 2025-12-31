package software.aoc.day04.b;

import software.aoc.day04.ForkliftAccess;
import software.aoc.day04.PaperMap;

public final class IterativeRemover {

    private final PaperMap initialMap;

    public IterativeRemover(PaperMap map) {
        this.initialMap = map;
    }

    public long totalRemoved() {
        PaperMap map = initialMap;
        long total = 0;
        long removed;
        do {
            boolean[][] accessible = new ForkliftAccess(map).accessibleMap();
            PaperRemover.RemovalResult result = PaperRemover.remove(map, accessible);
            map = result.newMap;
            removed = result.removed;
            total += removed;
        } while (removed > 0);
        return total;
    }
}
