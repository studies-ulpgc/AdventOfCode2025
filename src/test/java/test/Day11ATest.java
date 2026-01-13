package test;

import org.junit.Test;
import software.aoc.day11.model.DirectedGraph;
import software.aoc.day11.model.GraphParser;
import software.aoc.day11.model.PathCounter;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11ATest {

    @Test
    public void example_should_count_all_paths_from_you_to_out() throws Exception {
        String input = """
                aaa: you hhh
                you: bbb ccc
                bbb: ddd eee
                ccc: ddd eee fff
                ddd: ggg
                eee: out
                fff: out
                ggg: out
                hhh: ccc fff iii
                iii: out
                """;

        DirectedGraph graph = GraphParser.parse(input);
        long result = new PathCounter(graph).countPaths("you", "out");

        assertThat(result).isEqualTo(5);
    }
}
