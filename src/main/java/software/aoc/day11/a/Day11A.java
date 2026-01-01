package software.aoc.day11.a;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day11A {

    public static void main(String[] args) throws Exception {
        String day = "11-a";

        System.out.println("Part 1: " + getResult(day));
    }

    private static long getResult(String day) throws IOException {
        return PathSolverPart1.solve(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );
    }
}
