package software.aoc.day05.a;

import software.aoc.day05.IngredientDatabase;

public final class FreshnessCalculator {

    private final IngredientDatabase db;

    public FreshnessCalculator(IngredientDatabase db) {
        this.db = db;
    }

    public long countFreshIngredients() {
        return db.available().stream()
                .filter(id -> db.ranges().stream().anyMatch(r -> r.contains(id)))
                .count();
    }
}
