package test;

import org.junit.Test;
import software.aoc.day11.b.Day11BSolver;
import software.aoc.day11.b.ConstrainedPathCounter;
import software.aoc.day11.b.VisitState;
import software.aoc.day11.a.DirectedGraph;
import software.aoc.day11.a.GraphParser;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11BTest {

    @Test
    public void example_should_count_paths_visiting_dac_and_fft() throws Exception {
        String input = """
                svr: aaa bbb
                aaa: fft
                fft: ccc
                bbb: tty
                tty: ccc
                ccc: ddd eee
                ddd: hub
                hub: fff
                eee: dac
                dac: fff
                fff: ggg hhh
                ggg: out
                hhh: out
                """;

        DirectedGraph graph = GraphParser.parse(input);
        ConstrainedPathCounter counter = new ConstrainedPathCounter(graph);
        long result = counter.count("svr", "out", new VisitState(false, false));

        assertThat(result).isEqualTo(2);
    }
}
