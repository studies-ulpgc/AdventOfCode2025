package software.aoc.day05.a;

import software.aoc.day05.IngredientDatabase;
import software.aoc.day05.IngredientDatabaseFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Day05A {

    public static void main(String[] args) throws Exception {
        String day = "05-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );

        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(loader);
        long result = new FreshnessCalculator(db).countFreshIngredients();

        System.out.println(result);
    }
}
