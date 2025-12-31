package test;

import org.junit.Test;
import software.aoc.day10.a.LightSolver;
import software.aoc.day10.a.Machine;
import software.aoc.day10.a.MachineFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10ATest {

    private final LightSolver solver = new LightSolver();

    @Test
    public void given_example_machines_should_return_expected_flips() {
        // Ejemplo tomado del enunciado de Advent of Code
        String input =
                "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}\n" +
                        "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}\n" +
                        "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}";

        List<Machine> machines = MachineFactory.parse(input);

        int result = machines.stream()
                .mapToInt(solver::solve)
                .sum();

        // Ajusta el valor esperado según tu cálculo con la versión B
        assertThat(result).isEqualTo(7L);
    }

    @Test
    public void given_empty_list_should_return_zero() {
        List<Machine> machines = List.of();
        int result = machines.stream()
                .mapToInt(solver::solve)
                .sum();
        assertThat(result).isZero();
    }
}
