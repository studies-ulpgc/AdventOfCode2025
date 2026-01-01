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
        if (memo.containsKey(getKey(node, state))) return memo.get(getKey(node, state));

        if (node.equals(target)) {
            return getState(node, state).isValidAtEnd() ? 1 : 0;
        }

        memo.put(getKey(node, state), getTotal(node, target, state));
        return getTotal(node, target, state);
    }

    private long getTotal(String node, String target, VisitState state) {
        return graph.next(node).stream()
                .mapToLong(next -> count(next, target, getState(node, state)))
                .sum();
    }

    private static VisitState getState(String node, VisitState state) {
        return state.visit(node);
    }

    private static String getKey(String node, VisitState state) {
        return node + "|" + state.seenDac() + "|" + state.seenFft();
    }
}
