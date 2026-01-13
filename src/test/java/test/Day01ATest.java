package test;

import org.junit.Test;
import software.aoc.day01.model.Dial;
import software.aoc.day01.model.OrdersParser;

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
    public void should_count_times_at_zero() {
        var dial = Dial.create()
                .processOrdersCountingOnlyFinalZero(OrdersParser.parse(ORDERS));

        assertThat(dial.totalZeros()).isEqualTo(3);
    }
}
