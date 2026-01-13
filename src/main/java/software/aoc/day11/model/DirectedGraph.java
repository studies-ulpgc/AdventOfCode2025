package software.aoc.day11.model;

import java.util.List;
import java.util.Map;

public record DirectedGraph(Map<String, List<String>> edges) {
    public List<String> nextNode(String node) {
        return edges.getOrDefault(node, List.of());
    }
}
