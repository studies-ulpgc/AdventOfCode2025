package software.aoc.day11.b;

import software.aoc.day11.model.DirectedGraph;
import software.aoc.day11.model.GraphParser;
import software.aoc.day11.model.VisitState;
import software.aoc.input.OrdersLoader;

public final class ConstrainedPathSolver {

    public static long solve(OrdersLoader loader) {
        return createCounter(loader).count("svr", "out",
                new VisitState(false, false));
    }

    private static ConstrainedPathCounter createCounter(OrdersLoader loader) {
        return new ConstrainedPathCounter(parseGraph(loader));
    }

    private static DirectedGraph parseGraph(OrdersLoader loader) {
        return GraphParser.parse(loader.read());
    }
}
