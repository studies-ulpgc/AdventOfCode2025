package software.aoc.day09.b;

import software.aoc.day09.a.Point;
import software.aoc.day09.a.PointParser;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day09B {

    public static void main(String[] args) throws Exception {
        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day09-b/orders.txt")
                )
        );

        List<Point> points = PointParser.fromCSV(loader);

        Polygon polygon = PolygonFactory.fromRedLoop(points);
        var finder = new LargestRectangleFinderPart2(polygon);

        System.out.println("Part 2: " + finder.find(points));
    }
}
