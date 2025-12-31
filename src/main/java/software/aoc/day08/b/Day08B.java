package software.aoc.day08.b;

import software.aoc.day08.CircuitBuilder;
import software.aoc.day08.Point;
import software.aoc.day08.PointFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day08B {
    public static void main(String[] args) throws Exception {
        String day = "08-b";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
        List<Point> points = PointFactory.fromCSV(loader);
        CircuitBuilder builder = new CircuitBuilder();
        var edges = builder.buildAllEdges(points);

        long result = builder.lastEdgeProductX(points, edges);
        System.out.println("Product of X of last connected points: " + result);
    }
}
