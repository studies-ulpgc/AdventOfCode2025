package test;

import org.junit.Test;
import software.aoc.day12.parser.WorksheetParserFactory;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Day12Test {

    @Test
    public void given_example_input_should_compute_total_regions_correctly() {
        List<String> lines = Arrays.asList(
                "0:",
                "###",
                "##.",
                "##.",
                "",
                "1:",
                "###",
                "##.",
                ".##",
                "",
                "2:",
                ".##",
                "###",
                "##.",
                "",
                "3:",
                "##.",
                "###",
                "##.",
                "",
                "4:",
                "###",
                "#..",
                "###",
                "",
                "5:",
                "###",
                ".#.",
                "###",
                "",
                "4x4: 0 0 0 0 2 0",
                "12x5: 1 0 1 0 2 2",
                "12x5: 1 0 1 0 3 2"
        );

        var worksheet = WorksheetParserFactory.createWorksheet()
                .parse(lines);

        assertThat(worksheet.total()).isEqualTo(2);
    }
}