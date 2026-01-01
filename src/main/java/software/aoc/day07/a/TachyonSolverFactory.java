package software.aoc.day07.a;

import software.aoc.day07.Manifold;

public final class TachyonSolverFactory {

    private TachyonSolverFactory() {}

    public static TachyonSolver from(String input) {
        return new TachyonSolver(Manifold.from(input));
    }
}
