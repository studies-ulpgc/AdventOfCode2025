package test;

import org.junit.Test;
import software.aoc.day06.b.RightToLeftParser;
import software.aoc.day06.model.Worksheet;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06BTest {

    private final RightToLeftParser parser = new RightToLeftParser();

    private final String exampleInput =
            "123 328  51 64\n" +
                    " 45 64  387 23\n" +
                    "  6 98  215 314\n" +
                    "*   +   *   +  ";

    @Test
    public void given_example_should_compute_total() {
        Worksheet ws = parser.parse(exampleInput);
        assertThat(ws.total()).isEqualTo(3263827L);
    }

    @Test
    public void individual_problems_should_have_correct_values() {
        Worksheet ws = parser.parse(exampleInput);

        assertThat(ws.problems().get(0).solve()).isEqualTo(1058);
        assertThat(ws.problems().get(1).solve()).isEqualTo(3253600);
        assertThat(ws.problems().get(2).solve()).isEqualTo(625);
        assertThat(ws.problems().get(3).solve()).isEqualTo(8544);
    }
}
