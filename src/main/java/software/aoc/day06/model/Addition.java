package software.aoc.day06.model;

import java.util.List;

public final class Addition implements Operation {

    @Override
    public long apply(List<Long> values) {
        return values.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
