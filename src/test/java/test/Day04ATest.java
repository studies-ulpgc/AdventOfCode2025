package test;

import org.junit.Test;
import software.aoc.day04.model.ForkliftAccess;
import software.aoc.day04.model.PaperMap;
import software.aoc.day04.model.PaperMapFactory;
import software.aoc.input.OrdersLoader;
import software.aoc.input.FileOrdersLoader;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class Day04ATest {

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
    public void given_example_grid_should_count_accessible_rolls() {
        OrdersLoader loader = FileOrdersLoader.from(
                new ByteArrayInputStream(EXAMPLE_GRID.getBytes(StandardCharsets.UTF_8))
        );

        PaperMap map = PaperMapFactory.createPaperMapFromLoader(loader);
        long accessible = new ForkliftAccess(map).accessibleRolls();

        assertThat(accessible).isEqualTo(13);
    }
}
