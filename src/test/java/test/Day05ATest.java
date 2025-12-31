package test;

import org.junit.Test;
import software.aoc.day05.IngredientDatabase;
import software.aoc.day05.IngredientDatabaseFactory;
import software.aoc.day05.a.*;
import software.aoc.io.OrdersLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05ATest {

    private final OrdersLoader loader = new OrdersLoader() {
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
    public void given_example_input_should_count_fresh_ingredients() {
        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(loader);
        long result = new FreshnessCalculator(db).countFreshIngredients();

        assertThat(result).isEqualTo(3L);
    }

    @Test
    public void given_overlapping_ranges_should_still_count_correctly() {
        OrdersLoader overlappingLoader = new OrdersLoader() {
            @Override
            public String read() {
                return """
                       1-10
                       5-15
                       12-20

                       5
                       10
                       15
                       20
                       25
                       """;
            }
        };

        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(overlappingLoader);
        long result = new FreshnessCalculator(db).countFreshIngredients();

        assertThat(result).isEqualTo(4L);
    }

    @Test
    public void given_no_fresh_ingredients_should_return_zero() {
        OrdersLoader emptyLoader = new OrdersLoader() {
            @Override
            public String read() {
                return """
                       100-200

                       1
                       2
                       3
                       """;
            }
        };

        IngredientDatabase db = IngredientDatabaseFactory.fromLoader(emptyLoader);
        long result = new FreshnessCalculator(db).countFreshIngredients();

        assertThat(result).isEqualTo(0L);
    }
}
