package software.aoc.day06.model;

import java.util.List;

public final class Multiplication implements Operation {

    @Override
    public long apply(List<Long> values) {
        return values.stream()
                .reduce(1L, (a, b) -> a * b);
    }
}
