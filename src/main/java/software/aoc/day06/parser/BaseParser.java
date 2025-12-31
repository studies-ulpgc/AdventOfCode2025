package software.aoc.day06.parser;

import java.util.List;

public abstract class BaseParser {

    protected List<String> lines(String input) {
        return input.lines()
                .filter(l -> !l.isBlank())
                .toList();
    }

    protected int width(List<String> lines) {
        return lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    protected List<String> pad(List<String> lines, int width) {
        return lines.stream()
                .map(l -> String.format("%-" + width + "s", l))
                .toList();
    }
}
