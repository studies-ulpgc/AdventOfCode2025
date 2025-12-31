package software.aoc.day07.b;

import software.aoc.day07.a.Manifold;

public final class QuantumSolverFactory {

    private QuantumSolverFactory() {}

    public static QuantumSolver from(String input) {
        return new QuantumSolver(Manifold.from(input));
    }
}
