package software.aoc.day11.a;

import software.aoc.day11.model.DirectedGraph;
import software.aoc.day11.model.GraphParser;
import software.aoc.day11.model.PathCounter;
import software.aoc.input.OrdersLoader;

public final class SimplePathSolver {

    public static long solve(OrdersLoader loader) {
        return createCounter(loader).countPaths("you", "out");
    }

    private static PathCounter createCounter(OrdersLoader loader) {
        return new PathCounter(parseGraph(loader));
    }

    private static DirectedGraph parseGraph(OrdersLoader loader) {
        return GraphParser.parse(loader.read());
    }
}
