package software.aoc.day08.b;

import software.aoc.day08.model.CircuitBuilder;
import software.aoc.day08.model.Edge;
import software.aoc.day08.model.Point;
import software.aoc.day08.model.PointFactory;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day08B {
    public static void main(String[] args) throws Exception {
        System.out.println("Result: " + getResult("08-b"));
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
