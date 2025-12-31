package software.aoc.day08.a;

import software.aoc.day08.CircuitBuilder;
import software.aoc.day08.Point;
import software.aoc.day08.PointFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day08A {
    public static void main(String[] args) throws Exception {
        String day = "08-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
        List<Point> points = PointFactory.fromCSV(loader);
        CircuitBuilder builder = new CircuitBuilder();
        var edges = builder.buildAllEdges(points);
        var mst = builder.kruskal(edges, points.size(), 1000);
        int[] sizes = builder.componentSizes(points.size(), mst);
        System.out.println("Product of top 3 components: " + builder.top3Product(sizes));
    }
}
