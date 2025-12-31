package software.aoc.day11.a;

import java.util.HashMap;
import java.util.Map;

public final class PathCounter {

    private final DirectedGraph graph;
    private final Map<String, Long> memo = new HashMap<>();

    public PathCounter(DirectedGraph graph) {
        this.graph = graph;
    }

    public long countPaths(String from, String to) {
        if (from.equals(to)) return 1;
        if (memo.containsKey(from)) return memo.get(from);

        long total = graph.next(from).stream()
                .mapToLong(next -> countPaths(next, to))
                .sum();

        memo.put(from, total);
        return total;
    }
}
