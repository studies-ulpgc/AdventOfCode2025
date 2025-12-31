package software.aoc.day06.model;

import java.util.List;

public record Worksheet(List<Problem> problems) {

    public long total() {
        return problems.stream()
                .mapToLong(Problem::solve)
                .sum();
    }
}
