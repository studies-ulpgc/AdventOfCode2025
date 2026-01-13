package software.aoc.day07.a;

import software.aoc.day07.model.BeamMap;

public final class TachyonSolverFactory {

    private TachyonSolverFactory() {}

    public static TachyonSolver from(String input) {
        return new TachyonSolver(BeamMap.from(input));
    }
}
