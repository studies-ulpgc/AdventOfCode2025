package test;

import org.junit.Test;
import software.aoc.day05.model.IngredientDatabase;
import software.aoc.day05.model.IngredientDatabaseFactory;
import software.aoc.day05.b.FreshRangeCalculator;
import software.aoc.input.OrdersLoader;

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
        IngredientDatabase db = IngredientDatabaseFactory.createFromOrdersLoader(exampleLoader);
        FreshRangeCalculator calc = new FreshRangeCalculator(db);

        assertThat(calc.countFreshIngredientIds()).isEqualTo(14L);
    }
}
