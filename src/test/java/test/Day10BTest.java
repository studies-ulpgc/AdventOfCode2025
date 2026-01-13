package test;

import org.junit.Test;
import software.aoc.day10.model.Machine;
import software.aoc.day10.model.MachineLoader;
import software.aoc.day10.b.VoltageSolver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10BTest {

    private final VoltageSolver solver = new VoltageSolver();

    @Test
    public void given_example_machines_should_return_expected_flips() {
        String input =
                "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}\n" +
                        "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}\n" +
                        "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}";

        List<Machine> machines = MachineLoader.parseMachinesFromText(input);

        long result = solver.totalMinimumFlips(machines);

        assertThat(result).isEqualTo(33);
    }
}
