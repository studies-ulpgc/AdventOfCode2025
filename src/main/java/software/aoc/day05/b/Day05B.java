package software.aoc.day05.b;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;
import software.aoc.day05.IngredientDatabase;
import software.aoc.day05.IngredientDatabaseFactory;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Day05B {

    public static void main(String[] args) throws Exception {
        String day = "05-b";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );

        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(loader);
        long result = new FreshRangeCalculator(db).countFreshIDs();

        System.out.println(result);
    }
}
