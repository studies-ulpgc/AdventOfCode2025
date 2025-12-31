package test;

import org.junit.Test;
import software.aoc.day05.IngredientDatabase;
import software.aoc.day05.IngredientDatabaseFactory;
import software.aoc.day05.b.FreshRangeCalculator;
import software.aoc.io.OrdersLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05BTest {

    private final OrdersLoader exampleLoader = new OrdersLoader() {
        @Override
        public String read() {
            return """
                   3-5
                   10-14
                   16-20
                   12-18

                   1
                   5
                   8
                   11
                   17
                   32
                   """;
        }
    };

    @Test
    public void given_example_input_should_count_all_fresh_ids() {
        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(exampleLoader);
        FreshRangeCalculator calc = new FreshRangeCalculator(db);

        assertThat(calc.countFreshIDs()).isEqualTo(14L);
    }

    @Test
    public void given_non_overlapping_ranges_should_count_correctly() {
        OrdersLoader loader = new OrdersLoader() {
            @Override
            public String read() {
                return """
                       1-3
                       5-7
                       10-12

                       0
                       4
                       8
                       9
                       13
                       """;
            }
        };

        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(loader);
        FreshRangeCalculator calc = new FreshRangeCalculator(db);

        assertThat(calc.countFreshIDs()).isEqualTo(9L);
    }

    @Test
    public void given_fully_overlapping_ranges_should_count_unique_ids() {
        OrdersLoader loader = new OrdersLoader() {
            @Override
            public String read() {
                return """
                       1-10
                       5-15
                       12-20

                       0
                       25
                       """;
            }
        };

        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(loader);
        FreshRangeCalculator calc = new FreshRangeCalculator(db);

        assertThat(calc.countFreshIDs()).isEqualTo(20L);
    }

    @Test
    public void given_single_large_range_should_count_correctly() {
        OrdersLoader loader = new OrdersLoader() {
            @Override
            public String read() {
                return """
                       1000000000-1000000100

                       0
                       999999999
                       """;
            }
        };

        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(loader);
        FreshRangeCalculator calc = new FreshRangeCalculator(db);

        assertThat(calc.countFreshIDs()).isEqualTo(101L);
    }
}
