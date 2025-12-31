package software.aoc.day09.a;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day09A {

    public static void main(String[] args) throws Exception {
        String day = "09-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );

        List<Point> points = PointParser.fromCSV(loader);
        LargestRectangleFinder finder = new LargestRectangleFinderPart1();

        System.out.println("Part 1: " + finder.find(points));
    }
}
