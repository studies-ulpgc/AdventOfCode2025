package software.aoc.day11.a;

import java.util.List;
import java.util.Map;

public record DirectedGraph(Map<String, List<String>> edges) {

    public List<String> next(String node) {
        return edges.getOrDefault(node, List.of());
    }

    public boolean contains(String node) {
        return edges.containsKey(node);
    }
}
