package software.aoc.day04.a;

import software.aoc.day04.ForkliftAccess;
import software.aoc.day04.PaperMap;
import software.aoc.day04.PaperMapFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Day04A {

    public static void main(String[] args) throws Exception {
        String day = "04-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );

        PaperMap map = PaperMapFactory.fromLoader(loader);
        long result = new ForkliftAccess(map).accessibleRolls();

        System.out.println(result);
    }
}
