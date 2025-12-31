package software.aoc.day07.a;

public final class TachyonSolverFactory {

    private TachyonSolverFactory() {}

    public static TachyonSolver from(String input) {
        return new TachyonSolver(Manifold.from(input));
    }
}
