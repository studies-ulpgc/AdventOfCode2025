package software.aoc.day05.a;

import software.aoc.day05.model.IngredientDatabase;
import software.aoc.day05.model.IngredientDatabaseFactory;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day05A {

    public static void main(String[] args) throws Exception {
        System.out.println(getResult("05-a"));
    }

    private static long getResult(String day) throws IOException {
        return new FreshnessCalculator(getDatabase(day)).countFreshIngredients();
    }

    private static IngredientDatabase getDatabase(String day) throws IOException {
        return IngredientDatabaseFactory.createFromOrdersLoader(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
