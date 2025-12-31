package test;

import org.junit.Test;
import software.aoc.day06.a.LeftToRightParser;
import software.aoc.day06.model.Worksheet;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06ATest {

    private final LeftToRightParser parser = new LeftToRightParser();

    private final String exampleInput =
            "123 328  51 64\n" +
                    " 45 64  387 23\n" +
                    "  6 98  215 314\n" +
                    "*   +   *   +  ";

    @Test
    public void given_example_should_parse_correctly() {
        Worksheet ws = parser.parse(exampleInput);
        assertThat(ws.problems()).hasSize(4);
    }

    @Test
    public void given_example_should_compute_total() {
        Worksheet ws = parser.parse(exampleInput);
        assertThat(ws.total()).isEqualTo(4277556L);
    }

    @Test
    public void individual_problems_should_have_correct_values() {
        Worksheet ws = parser.parse(exampleInput);

        assertThat(ws.problems().get(0).solve()).isEqualTo(123 * 45 * 6); // 33210
        assertThat(ws.problems().get(1).solve()).isEqualTo(328 + 64 + 98); // 490
        assertThat(ws.problems().get(2).solve()).isEqualTo(51 * 387 * 215); // 4243455
        assertThat(ws.problems().get(3).solve()).isEqualTo(64 + 23 + 314); // 401
    }
}
