package software.aoc.day11.a;

import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day11A {

    public static void main(String[] args) throws Exception {
        System.out.println(getResult("11-a"));
    }

    private static long getResult(String day) throws IOException {
        return SimplePathSolver.solve(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );
    }
}
