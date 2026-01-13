package software.aoc.day05.model;

import software.aoc.input.OrdersLoader;

import java.util.List;
import java.util.stream.Stream;

public final class IngredientDatabaseFactory {

    private IngredientDatabaseFactory() {}

    public static IngredientDatabase createFromOrdersLoader(OrdersLoader loader) {
        String data = loader.read();
        return new IngredientDatabase(parseFreshnessRanges(data), parseAvailableIngredientIds(data));
    }

    private static List<IngredientRange> parseFreshnessRanges(String input) {
        return Stream.of(input.split("\n\n")[0].split("\n"))
                .map(s -> s.split("-"))
                .map(a -> new IngredientRange(Long.parseLong(a[0]), Long.parseLong(a[1])))
                .toList();
    }

    private static List<Long> parseAvailableIngredientIds(String input) {
        return Stream.of(input.split("\n\n")[1].split("\n"))
                .map(Long::parseLong)
                .toList();
    }
}
