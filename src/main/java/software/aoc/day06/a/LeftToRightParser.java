package software.aoc.day06.a;

import software.aoc.day06.model.*;
import software.aoc.day06.parser.*;

import java.util.ArrayList;
import java.util.List;

public final class LeftToRightParser extends BaseParser
        implements WorksheetParser {

    @Override
    public Worksheet parse(String input) {
        var raw = lines(input);
        var padded = pad(raw, width(raw));
        return new Worksheet(problems(padded));
    }

    private List<Problem> problems(List<String> lines) {
        return extract(lines.subList(0, lines.size() - 1),
                lines.get(lines.size() - 1));
    }

    private List<Problem> extract(List<String> nums, String ops) {
        var list = new ArrayList<Problem>();
        int start = -1;

        for (int c = 0; c <= ops.length(); c++) {
            if (inside(nums, ops, c)) {
                if (start < 0) start = c;
            } else if (start >= 0) {
                list.add(problem(nums, ops, start, c));
                start = -1;
            }
        }
        return list;
    }

    private boolean inside(List<String> nums, String ops, int c) {
        return c < ops.length() &&
                (ops.charAt(c) != ' ' ||
                        nums.stream().anyMatch(r -> r.charAt(c) != ' '));
    }

    private Problem problem(List<String> nums, String ops, int a, int b) {
        return new Problem(numbers(nums, a, b),
                OperationFactory.from(ops.charAt(a)));
    }

    private List<Long> numbers(List<String> rows, int a, int b) {
        return rows.stream()
                .flatMap(r -> List.of(r.substring(a, b).trim().split("\\s+")).stream())
                .filter(s -> !s.isBlank())
                .map(Long::parseLong)
                .toList();
    }
}
