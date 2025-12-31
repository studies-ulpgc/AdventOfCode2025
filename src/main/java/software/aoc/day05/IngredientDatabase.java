package software.aoc.day05;

import java.util.List;

public record IngredientDatabase(List<IngredientRange> ranges, List<Long> available) {}
