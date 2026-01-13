package software.aoc.day11.b;

import software.aoc.day11.model.DirectedGraph;
import software.aoc.day11.model.VisitState;

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
            return nextState(node, state).allRequiredNodesVisited() ? 1 : 0;
        }

        memo.put(getKey(node, state), sumPathsFromNode(node, target, state));
        return sumPathsFromNode(node, target, state);
    }

    private long sumPathsFromNode(String node, String target, VisitState state) {
        return graph.nextNode(node).stream()
                .mapToLong(next -> count(next, target, nextState(node, state)))
                .sum();
    }

    private static VisitState nextState(String node, VisitState state) {
        return state.visitNode(node);
    }

    private static String getKey(String node, VisitState state) {
        return node + "|" + state.seenDac() + "|" + state.seenFft();
    }
}
