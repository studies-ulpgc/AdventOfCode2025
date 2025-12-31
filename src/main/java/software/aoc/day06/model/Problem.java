package software.aoc.day06.model;

import java.util.List;

public record Problem(List<Long> numbers, Operation operation) {

    public long solve() {
        return operation.apply(numbers);
    }
}
