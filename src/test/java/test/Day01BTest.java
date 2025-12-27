package test;

import org.junit.Test;
import software.aoc.day01.Order;
import software.aoc.day01.OrdersParser;
import software.aoc.day01.b.Dial2;

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

        Dial2 result = Dial2.create().execute(orders);

        assertThat(result.position()).isEqualTo(32);
        assertThat(result.count()).isEqualTo(6);
    }

    @Test
    public void given_small_rotations_should_work_correctly() {
        List<Order> orders = List.of(
                new Order(-1),
                new Order(1),
                new Order(50)
        );

        Dial2 result = Dial2.create().execute(orders);

        assertThat(result.position()).isEqualTo(0);
        assertThat(result.count()).isEqualTo(1);
    }

    @Test
    public void given_large_rotation_should_count_multiple_zeros() {
        List<Order> orders = List.of(new Order(1000));

        Dial2 result = Dial2.create().execute(orders);

        assertThat(result.position()).isEqualTo(50);
        assertThat(result.count()).isEqualTo(10);
    }
}
