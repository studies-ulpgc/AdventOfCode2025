package software.aoc.day06.b;

import software.aoc.day06.model.*;
import software.aoc.day06.parser.*;

import java.util.ArrayList;
import java.util.List;

public final class RightToLeftParser extends BaseParser
        implements WorksheetParser {

    @Override
    public Worksheet parse(String input) {
        return new Worksheet(problems(pad(lines(input), width(lines(input)))));
    }

    private List<Problem> problems(List<String> lines) {
        return getList(getCol(lines), getNumbers(lines), getOps(lines), new ArrayList<Problem>());
    }

    private static List<String> getNumbers(List<String> lines) {
        return lines.subList(0, lines.size() - 1);
    }

    private static int getCol(List<String> lines) {
        return getOps(lines).length() - 1;
    }

    private static String getOps(List<String> lines) {
        return lines.get(lines.size() - 1);
    }

    private ArrayList<Problem> getList(int col, List<String> numbers, String ops, ArrayList<Problem> list) {
        while (col >= 0) {
            if (isSeparator(numbers, ops, col)) {
                col--;
                continue;
            }

            list.add(problem(numbers, ops, findStart(numbers, ops, col), col));
            col = findStart(numbers, ops, col) - 1;
        }
        return list;
    }

    private int findStart(List<String> nums, String ops, int end) {
        int c = end;
        while (c >= 0 && !isSeparator(nums, ops, c)) c--;
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
        return getList(rows, a, b, new ArrayList<Long>());
    }

    private ArrayList<Long> getList(List<String> rows, int a, int b, ArrayList<Long> list) {
        for (int c = b; c >= a; c--) {
            if (!columnNumber(rows, c).isEmpty())
                list.add(Long.parseLong(columnNumber(rows, c)));
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
