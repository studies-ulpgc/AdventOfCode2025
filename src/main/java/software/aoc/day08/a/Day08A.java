package software.aoc.day08.a;

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

public class Day08A {
    public static void main(String[] args) throws Exception {
        String day = "08-a";

        System.out.println("Result: " + getResult(getBuilder(), day));
    }

    private static long getResult(CircuitBuilder builder, String day) throws IOException {
        return builder.top3Product(getSizes(day));
    }

    private static int[] getSizes(String day) throws IOException {
        return getBuilder().componentSizes(getPoints(day).size(), getMst(day));
    }

    private static List<Edge> getMst(String day) throws IOException {
        return getBuilder().kruskal(getEdges(day), getPoints(day).size(), 1000);
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
