package test;

import org.junit.Test;
import software.aoc.day07.a.TachyonSolver;
import software.aoc.day07.a.TachyonSolverFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07ATest {
    @Test
    public void given_example_from_statement_should_return_expected_splits() {
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

        TachyonSolver solver = TachyonSolverFactory.from(input);

        int result = solver.solve();

        assertThat(result).isEqualTo(21);
    }
}
