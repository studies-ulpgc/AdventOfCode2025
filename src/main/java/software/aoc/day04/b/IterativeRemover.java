package software.aoc.day04.b;

import software.aoc.day04.model.ForkliftAccess;
import software.aoc.day04.model.PaperMap;

public final class IterativeRemover {

    private final PaperMap initialMap;

    public IterativeRemover(PaperMap map) {
        this.initialMap = map;
    }

    public long totalRemoved() {
        return removeAccessibleRollsUntilStable(initialMap, 0);
    }

    private static long removeAccessibleRollsUntilStable(PaperMap map, long total) {
        long removed;
        do {
            PaperRemover.RemovalResult result = PaperRemover.removeAccessiblePaperRolls(map, buildForkliftAccessibilityMatrix(map));
            map = result.newMap;
            removed = result.removed;
            total += removed;
        } while (removed > 0);
        return total;
    }

    private static boolean[][] buildForkliftAccessibilityMatrix(PaperMap map) {
        return new ForkliftAccess(map).buildForkliftAccessibilityMatrix();
    }
}
