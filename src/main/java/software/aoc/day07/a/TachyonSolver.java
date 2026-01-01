package software.aoc.day07.a;

import software.aoc.day07.Manifold;
import software.aoc.day07.Position;

import java.util.HashSet;
import java.util.Set;

public final class TachyonSolver {

    private final Manifold manifold;
    private final Set<Position> visited = new HashSet<>();

    TachyonSolver(Manifold manifold) {
        this.manifold = manifold;
    }

    public int solve() {
        return propagate(Set.of(new Beam(manifold.start()))).splits();
    }

    private SplitResult propagate(Set<Beam> beams) {
        if (beams.isEmpty()) return SplitResult.empty();

        return beams.stream()
                .map(this::step)
                .reduce(SplitResult.empty(), SplitResult::merge);
    }

    private SplitResult step(Beam beam) {
        Beam next = beam.moveDown();
        Position pos = next.position();

        if (!manifold.contains(pos)) return SplitResult.empty();
        if (!visited.add(pos)) return SplitResult.empty();

        return switch (manifold.at(pos)) {
            case '^' -> split(next);
            default -> propagate(Set.of(next));
        };
    }

    private SplitResult split(Beam at) {
        return propagate(Set.of(
                new Beam(at.position().left()),
                new Beam(at.position().right())
        )).merge(new SplitResult(Set.of(), 1));
    }
}
