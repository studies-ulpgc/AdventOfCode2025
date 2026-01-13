package test;

import org.junit.Test;
import software.aoc.day01.model.Order;
import software.aoc.day01.model.OrdersParser;
import software.aoc.day01.model.Dial;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01BTest {

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
    public void given_orders_should_count_zeros_during_rotations() {
        List<Order> orders = OrdersParser.parse(ORDERS);

        Dial result = Dial.create().processOrdersCountingAllIntermediateZeros(orders);

        assertThat(result.totalZeros()).isEqualTo(6);
    }
}
