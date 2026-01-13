package software.aoc.day07.b;

import software.aoc.day07.model.BeamMap;

public final class QuantumSolverFactory {

    private QuantumSolverFactory() {}

    public static QuantumSolver from(String input) {
        return new QuantumSolver(BeamMap.from(input));
    }
}
