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
        List<IngredientRange> sorted = db.ranges().stream()
                .sorted(Comparator.comparingLong(IngredientRange::start))
                .toList();

        long count = 0;
        long currentEnd = Long.MIN_VALUE;

        for (IngredientRange r : sorted) {
            long s = Math.max(r.start(), currentEnd + 1);
            long e = r.end();
            if (s <= e) {
                count += e - s + 1;
                currentEnd = e;
            }
        }

        return count;
    }
}
