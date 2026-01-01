package software.aoc.day11.b;

import software.aoc.day11.a.DirectedGraph;
import software.aoc.day11.a.GraphParser;
import software.aoc.io.OrdersLoader;

public final class PathSolverPart2 {

    public static long solve(OrdersLoader loader) {
        return getCounter(loader).count("svr", "out",
                new VisitState(false, false));
    }

    private static ConstrainedPathCounter getCounter(OrdersLoader loader) {
        return new ConstrainedPathCounter(getParse(loader));
    }

    private static DirectedGraph getParse(OrdersLoader loader) {
        return GraphParser.parse(loader.read());
    }
}
