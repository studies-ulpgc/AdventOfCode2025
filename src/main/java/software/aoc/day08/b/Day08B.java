package software.aoc.day08.b;

import software.aoc.day08.CircuitBuilder;
import software.aoc.day08.Edge;
import software.aoc.day08.Point;
import software.aoc.day08.PointFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day08B {
    public static void main(String[] args) throws Exception {
        String day = "08-b";

        System.out.println("Result: " + getResult(day));
    }

    private static long getResult(String day) throws IOException {
        return getBuilder().lastEdgeProductX(getPoints(day), getEdges(day));
    }

    private static List<Edge> getEdges(String day) throws IOException {
        return getBuilder().buildAllEdges(getPoints(day));
    }

    private static CircuitBuilder getBuilder() {
        return new CircuitBuilder();
    }

    private static List<Point> getPoints(String day) throws IOException {
        return PointFactory.fromCSV(getLoader(day));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
