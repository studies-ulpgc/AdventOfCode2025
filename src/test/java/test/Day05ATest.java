package test;

import org.junit.Test;
import software.aoc.day05.model.IngredientDatabase;
import software.aoc.day05.model.IngredientDatabaseFactory;
import software.aoc.day05.a.*;
import software.aoc.input.OrdersLoader;

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
        IngredientDatabase db = IngredientDatabaseFactory.createFromOrdersLoader(loader);
        long result = new FreshnessCalculator(db).countFreshIngredients();

        assertThat(result).isEqualTo(3L);
    }
}
