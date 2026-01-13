package software.aoc.day04.a;

import software.aoc.day04.model.ForkliftAccess;
import software.aoc.day04.model.PaperMap;
import software.aoc.day04.model.PaperMapFactory;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day04A {

    public static void main(String[] args) throws Exception {
        System.out.println(getResult("04-a"));
    }

    private static long getResult(String day) throws IOException {
        return new ForkliftAccess(getMap(day)).accessibleRolls();
    }

    private static PaperMap getMap(String day) throws IOException {
        return PaperMapFactory.createPaperMapFromLoader(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
