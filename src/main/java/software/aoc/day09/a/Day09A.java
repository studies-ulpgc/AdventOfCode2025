package software.aoc.day09.a;

import software.aoc.day09.finder.BruteForceLargestRectangleFinder;
import software.aoc.day09.model.Point;
import software.aoc.day09.model.PointParser;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day09A {

    public static void main(String[] args) throws Exception {
        System.out.println("Resultado: " + getResult("09-a"));
    }

    private static long getResult(String day) throws IOException {
        return getFinder().findLargestRectangle(getPoints(day));
    }

    private static BruteForceLargestRectangleFinder getFinder() {
        return new BruteForceLargestRectangleFinder();
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
