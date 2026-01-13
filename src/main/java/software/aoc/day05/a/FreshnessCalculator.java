package software.aoc.day05.a;

import software.aoc.day05.model.IngredientDatabase;

import java.util.function.Predicate;

public final class FreshnessCalculator {

    private final IngredientDatabase ingredientDatabase;

    public FreshnessCalculator(IngredientDatabase ingredientDatabase) {
        this.ingredientDatabase = ingredientDatabase;
    }

    public long countFreshIngredients() {
        return ingredientDatabase.available().stream()
                .filter(isIngredientFresh())
                .count();
    }

    private Predicate<Long> isIngredientFresh() {
        return id -> ingredientDatabase.ranges().stream().anyMatch(r -> r.contains(id));
    }
}
