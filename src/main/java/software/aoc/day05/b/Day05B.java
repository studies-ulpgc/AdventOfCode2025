package software.aoc.day05.b;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;
import software.aoc.day05.IngredientDatabase;
import software.aoc.day05.IngredientDatabaseFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day05B {

    public static void main(String[] args) throws Exception {
        String day = "05-b";

        System.out.println(getResult(day));
    }

    private static long getResult(String day) throws IOException {
        return new FreshRangeCalculator(getDatabase(day)).countFreshIDs();
    }

    private static IngredientDatabase getDatabase(String day) throws IOException {
        return IngredientDatabaseFactory.fromLoader(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
