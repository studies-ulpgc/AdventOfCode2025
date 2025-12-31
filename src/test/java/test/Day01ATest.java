package test;

import org.junit.Test;
import software.aoc.day01.Dial;
import software.aoc.day01.OrdersParser;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ATest {

    private static final String ORDERS = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
            """;

    @Test
    public void should_compute_final_position() {
        var dial = Dial.create()
                .execute_left_pointing(OrdersParser.parse(ORDERS));

        assertThat(dial.position()).isEqualTo(32);
    }

    @Test
    public void should_count_times_at_zero() {
        var dial = Dial.create()
                .execute_left_pointing(OrdersParser.parse(ORDERS));

        assertThat(dial.count()).isEqualTo(3);
    }

    @Test
    public void should_handle_large_rotations() {
        var dial = Dial.create()
                .execute_left_pointing(OrdersParser.parse("L51\nL500"));

        assertThat(dial.position()).isEqualTo(99);
        assertThat(dial.count()).isEqualTo(0);
    }
}
