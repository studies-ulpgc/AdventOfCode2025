package software.aoc.day11.model;

import java.util.HashMap;
import java.util.Map;

public final class PathCounter {

    private final DirectedGraph graph;
    private final Map<String, Long> memoization = new HashMap<>();

    public PathCounter(DirectedGraph graph) {
        this.graph = graph;
    }

    public long countPaths(String from, String to) {
        if (from.equals(to)) return 1;
        if (memoization.containsKey(from)) return memoization.get(from);

        long total = graph.nextNode(from).stream()
                .mapToLong(next -> countPaths(next, to))
                .sum();

        memoization.put(from, total);
        return total;
    }
}
