package software.aoc.day04.a;

import software.aoc.day04.ForkliftAccess;
import software.aoc.day04.PaperMap;
import software.aoc.day04.PaperMapFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day04A {

    public static void main(String[] args) throws Exception {
        String day = "04-a";

        System.out.println(getResult(day));
    }

    private static long getResult(String day) throws IOException {
        return new ForkliftAccess(getMap(day)).accessibleRolls();
    }

    private static PaperMap getMap(String day) throws IOException {
        return PaperMapFactory.fromLoader(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
