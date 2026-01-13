package software.aoc.day09.b;

import software.aoc.day09.finder.PolygonConstrainedRectangleFinder;
import software.aoc.day09.model.Point;
import software.aoc.day09.model.PointParser;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day09B {

    public static void main(String[] args) throws Exception {
        System.out.println("Resultado: " + getResult());
    }

    private static long getResult() throws IOException {
        return getFinder().findLargestRectangle(getPoints());
    }

    private static PolygonConstrainedRectangleFinder getFinder() throws IOException {
        return new PolygonConstrainedRectangleFinder(getPolygon());
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
