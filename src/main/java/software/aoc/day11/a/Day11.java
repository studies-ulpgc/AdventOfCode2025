package software.aoc.day11.a;

import software.aoc.io.OrdersLoader;

public final class Day11 {

    public static long solve(OrdersLoader loader) {
        DirectedGraph graph = GraphParser.parse(loader.read());
        PathCounter counter = new PathCounter(graph);
        return counter.countPaths("you", "out");
    }
}
