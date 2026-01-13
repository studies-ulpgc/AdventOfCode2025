package test;

import org.junit.Test;
import software.aoc.day07.b.QuantumSolver;
import software.aoc.day07.b.QuantumSolverFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07BTest {
    @Test
    public void given_example_from_statement_should_return_expected_timelines() {
        String input =
                ".......S.......\n" +
                        "...............\n" +
                        ".......^.......\n" +
                        "...............\n" +
                        "......^.^......\n" +
                        "...............\n" +
                        ".....^.^.^.....\n" +
                        "...............\n" +
                        "....^.^...^....\n" +
                        "...............\n" +
                        "...^.^...^.^...\n" +
                        "...............\n" +
                        "..^...^.....^..\n" +
                        "...............\n" +
                        ".^.^.^.^.^...^.\n" +
                        "...............";

        QuantumSolver solver = QuantumSolverFactory.from(input);

        long result = solver.solve();

        assertThat(result).isEqualTo(40);
    }
}
