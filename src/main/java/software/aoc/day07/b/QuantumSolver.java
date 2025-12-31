package software.aoc.day07.b;

import software.aoc.day07.a.Manifold;
import software.aoc.day07.a.Position;

import java.util.HashMap;
import java.util.Map;

public final class QuantumSolver {

    private final Manifold manifold;
    private final Map<Position, Long> memo = new HashMap<>();

    QuantumSolver(Manifold manifold) {
        this.manifold = manifold;
    }

    public long solve() {
        return count(manifold.start());
    }

    private long count(Position pos) {
        if (!manifold.contains(pos)) return 1;
        if (memo.containsKey(pos)) return memo.get(pos);

        long result;
        switch (manifold.at(pos)) {
            case '^':
                result = count(pos.left()) + count(pos.right());
                break;
            default:
                result = count(pos.down());
        }
        memo.put(pos, result);
        return result;
    }


    private long countFrom(Position pos) {
        return switch (manifold.at(pos)) {
            case '^' -> count(pos.left()) + count(pos.right());
            default  -> count(pos.down());
        };
    }
}
