package test;

import org.junit.Test;
import software.aoc.day04.model.PaperMap;
import software.aoc.day04.model.PaperMapFactory;
import software.aoc.day04.b.IterativeRemover;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class Day04BTest {

    private static final String EXAMPLE_GRID =
            "..@@.@@@@.\n" +
                    "@@@.@.@.@@\n" +
                    "@@@@@.@.@@\n" +
                    "@.@@@@..@.\n" +
                    "@@.@@@@.@@\n" +
                    ".@@@@@@@.@\n" +
                    ".@.@.@.@@@\n" +
                    "@.@@@.@@@@\n" +
                    ".@@@@@@@@.\n" +
                    "@.@.@@@.@.";

    @Test
    public void given_example_grid_should_remove_all_accessible_rolls() {
        OrdersLoader loader = FileOrdersLoader.from(
                new ByteArrayInputStream(EXAMPLE_GRID.getBytes(StandardCharsets.UTF_8))
        );

        PaperMap map = PaperMapFactory.createPaperMapFromLoader(loader);
        long totalRemoved = new IterativeRemover(map).totalRemoved();

        assertThat(totalRemoved).isEqualTo(43);
    }
}
