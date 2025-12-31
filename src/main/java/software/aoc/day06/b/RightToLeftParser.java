package software.aoc.day06.b;

import software.aoc.day06.model.*;
import software.aoc.day06.parser.*;

import java.util.ArrayList;
import java.util.List;

public final class RightToLeftParser extends BaseParser
        implements WorksheetParser {

    @Override
    public Worksheet parse(String input) {
        var raw = lines(input);
        var padded = pad(raw, width(raw));
        return new Worksheet(problems(padded));
    }

    private List<Problem> problems(List<String> lines) {
        var numbers = lines.subList(0, lines.size() - 1);
        var ops = lines.get(lines.size() - 1);

        var list = new ArrayList<Problem>();
        int col = ops.length() - 1;

        while (col >= 0) {
            if (isSeparator(numbers, ops, col)) {
                col--;
                continue;
            }

            int end = col;
            int start = findStart(numbers, ops, end);

            list.add(problem(numbers, ops, start, end));
            col = start - 1;
        }

        return list;
    }

    private int findStart(List<String> nums, String ops, int end) {
        int c = end;
        while (c >= 0 && !isSeparator(nums, ops, c)) {
            c--;
        }
        return c + 1;
    }

    private boolean isSeparator(List<String> nums, String ops, int c) {
        return ops.charAt(c) == ' ' &&
                nums.stream().allMatch(r -> r.charAt(c) == ' ');
    }

    private Problem problem(List<String> nums, String ops, int a, int b) {
        return new Problem(numbers(nums, a, b),
                OperationFactory.from(ops.charAt(a)));
    }

    private List<Long> numbers(List<String> rows, int a, int b) {
        var list = new ArrayList<Long>();

        for (int c = b; c >= a; c--) {
            var n = columnNumber(rows, c);
            if (!n.isEmpty()) {
                list.add(Long.parseLong(n));
            }
        }
        return list;
    }

    private String columnNumber(List<String> rows, int c) {
        return rows.stream()
                .map(r -> r.charAt(c))
                .filter(ch -> ch != ' ')
                .map(String::valueOf)
                .reduce("", String::concat);
    }
}
