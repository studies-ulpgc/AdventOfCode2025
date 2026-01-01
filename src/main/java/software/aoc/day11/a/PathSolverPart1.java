package software.aoc.day11.a;

import software.aoc.io.OrdersLoader;

public final class PathSolverPart1 {

    public static long solve(OrdersLoader loader) {
        return getCounter(loader).countPaths("you", "out");
    }

    private static PathCounter getCounter(OrdersLoader loader) {
        return new PathCounter(getParse(loader));
    }

    private static DirectedGraph getParse(OrdersLoader loader) {
        return GraphParser.parse(loader.read());
    }
}
