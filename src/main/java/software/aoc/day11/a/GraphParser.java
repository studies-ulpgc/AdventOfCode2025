package software.aoc.day11.a;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public final class GraphParser {

    private GraphParser() {}

    public static DirectedGraph parse(String input) {
        Map<String, java.util.List<String>> edges =
                input.lines()
                     .map(String::trim)
                     .filter(l -> !l.isBlank())
                     .map(line -> line.split(":"))
                     .collect(Collectors.toMap(
                             parts -> parts[0].trim(),
                             parts -> Arrays.stream(parts[1].trim().split("\\s+"))
                                            .toList()
                     ));

        return new DirectedGraph(edges);
    }
}
