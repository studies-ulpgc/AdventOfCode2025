package software.aoc.day05.model;

import java.util.List;

public record IngredientDatabase(List<IngredientRange> ranges, List<Long> available) {}
