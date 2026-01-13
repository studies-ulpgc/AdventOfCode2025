package software.aoc.day07.model;

import java.util.Set;

public record SplitResult(Set<Beam> beams, int splits) {

    public static SplitResult empty() {
        return new SplitResult(Set.of(), 0);
    }

    public SplitResult merge(SplitResult other) {
        return new SplitResult(
                union(beams, other.beams),
                splits + other.splits
        );
    }

    private static Set<Beam> union(Set<Beam> a, Set<Beam> b) {
        return new java.util.HashSet<>() {{
            addAll(a);
            addAll(b);
        }};
    }
}
