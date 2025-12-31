package software.aoc.day11.a;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Day11A {

    public static void main(String[] args) throws Exception {
        String day = "11-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );

        long result = Day11.solve(loader);

        System.out.println("Part 1: " + result);
    }
}
