package software.aoc.day11.b;

import software.aoc.day11.a.DirectedGraph;
import software.aoc.day11.a.GraphParser;
import software.aoc.io.OrdersLoader;

public final class Day11BSolver {

    public static long solve(OrdersLoader loader) {
        DirectedGraph graph = GraphParser.parse(loader.read());
        ConstrainedPathCounter counter = new ConstrainedPathCounter(graph);

        return counter.count("svr", "out", new VisitState(false, false));
    }
}
