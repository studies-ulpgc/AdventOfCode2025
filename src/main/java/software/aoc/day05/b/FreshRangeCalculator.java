package software.aoc.day05.b;

import software.aoc.day05.model.IngredientDatabase;
import software.aoc.day05.model.IngredientRange;

import java.util.Comparator;
import java.util.List;

public final class FreshRangeCalculator {

    private final IngredientDatabase ingredientDatabase;

    public FreshRangeCalculator(IngredientDatabase ingredientDatabase) {
        this.ingredientDatabase = ingredientDatabase;
    }

    public long countFreshIngredientIds() {
        return getCountIdsInMergedRanges(getSortedByStart(), Long.MIN_VALUE, 0);
    }

    private List<IngredientRange> getSortedByStart() {
        return ingredientDatabase.ranges().stream()
                .sorted(Comparator.comparingLong(IngredientRange::start))
                .toList();
    }

    private static long getCountIdsInMergedRanges(List<IngredientRange> sorted, long currentEnd, long count) {
        for (IngredientRange r : sorted) {
            if (getFirstUncoveredId(currentEnd, r) > r.end()) continue;
            count += r.end() - getFirstUncoveredId(currentEnd, r) + 1;
            currentEnd = r.end();
        }
        return count;
    }

    private static long getFirstUncoveredId(long currentEnd, IngredientRange r) {
        return Math.max(r.start(), currentEnd + 1);
    }
}
