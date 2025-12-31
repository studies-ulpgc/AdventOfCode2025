package software.aoc.day11.b;

import software.aoc.day11.a.DirectedGraph;

import java.util.HashMap;
import java.util.Map;

public final class ConstrainedPathCounter {

    private final DirectedGraph graph;
    private final Map<String, Long> memo = new HashMap<>();

    public ConstrainedPathCounter(DirectedGraph graph) {
        this.graph = graph;
    }

    public long count(String node, String target, VisitState state) {
        String key = node + "|" + state.seenDac() + "|" + state.seenFft();
        if (memo.containsKey(key)) return memo.get(key);

        VisitState newState = state.visit(node);

        if (node.equals(target)) {
            return newState.isValidAtEnd() ? 1 : 0;
        }

        long total = graph.next(node).stream()
                .mapToLong(next -> count(next, target, newState))
                .sum();

        memo.put(key, total);
        return total;
    }
}
