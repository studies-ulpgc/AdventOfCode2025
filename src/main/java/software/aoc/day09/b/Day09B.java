package software.aoc.day09.b;

import software.aoc.day09.Point;
import software.aoc.day09.a.PointParser;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day09B {

    public static void main(String[] args) throws Exception {
        System.out.println("Resultado: " + getResult());
    }

    private static long getResult() throws IOException {
        return getFinder().find(getPoints());
    }

    private static LargestRectangleFinderPart2 getFinder() throws IOException {
        return new LargestRectangleFinderPart2(getPolygon());
    }

    private static Polygon getPolygon() throws IOException {
        return PolygonFactory.fromRedLoop(getPoints());
    }

    private static List<Point> getPoints() throws IOException {
        return PointParser.fromCSV(getLoader());
    }

    private static OrdersLoader getLoader() throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day09-b/orders.txt")
                )
        );
    }
}
