package software.aoc.day09.a;

import software.aoc.day09.Point;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day09A {

    public static void main(String[] args) throws Exception {
        String day = "09-a";

        System.out.println("Resultado: " + getResult(day));
    }

    private static long getResult(String day) throws IOException {
        return getFinder().find(getPoints(day));
    }

    private static LargestRectangleFinderPart1 getFinder() {
        return new LargestRectangleFinderPart1();
    }

    private static List<Point> getPoints(String day) throws IOException {
        return PointParser.fromCSV(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
