package software.aoc.day05.b;

import software.aoc.day05.IngredientDatabase;
import software.aoc.day05.IngredientRange;

import java.util.Comparator;
import java.util.List;

public final class FreshRangeCalculator {

    private final IngredientDatabase db;

    public FreshRangeCalculator(IngredientDatabase db) {
        this.db = db;
    }

    public long countFreshIDs() {
        return getCount(getSorted(), Long.MIN_VALUE, 0);
    }

    private List<IngredientRange> getSorted() {
        return db.ranges().stream()
                .sorted(Comparator.comparingLong(IngredientRange::start))
                .toList();
    }

    private static long getCount(List<IngredientRange> sorted, long currentEnd, long count) {
        for (IngredientRange r : sorted) {
            if (getMax(currentEnd, r) > r.end()) continue;
            count += r.end() - getMax(currentEnd, r) + 1;
            currentEnd = r.end();
        }
        return count;
    }

    private static long getMax(long currentEnd, IngredientRange r) {
        return Math.max(r.start(), currentEnd + 1);
    }
}
