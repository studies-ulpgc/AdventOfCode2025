package software.aoc.day06.a;

import software.aoc.day06.model.*;
import software.aoc.day06.parser.*;

import java.util.ArrayList;
import java.util.List;

public final class LeftToRightParser extends BaseParser
        implements WorksheetParser {

    @Override
    public Worksheet parse(String input) {
        return new Worksheet(parseProblems(pad(lines(input), width(lines(input)))));
    }

    private List<Problem> parseProblems(List<String> lines) {
        return extract(lines.subList(0, lines.size() - 1),
                lines.get(lines.size() - 1));
    }

    private List<Problem> extract(List<String> nums, String ops) {
        return extractProblemsFromColumns(nums, ops, -1, new ArrayList<Problem>());
    }

    private ArrayList<Problem> extractProblemsFromColumns(List<String> nums, String ops, int start, ArrayList<Problem> list) {
        for (int c = 0; c <= ops.length(); c++) {
            if (isInsideProblemBlock(nums, ops, c)) {
                if (start < 0) start = c;
            } else if (start >= 0) {
                list.add(buildProblem(nums, ops, start, c));
                start = -1;
            }
        }
        return list;
    }

    private boolean isInsideProblemBlock(List<String> nums, String ops, int c) {
        return c < ops.length() &&
                (ops.charAt(c) != ' ' ||
                        nums.stream().anyMatch(r -> r.charAt(c) != ' '));
    }

    private Problem buildProblem(List<String> nums, String ops, int a, int b) {
        return new Problem(extractNumbersFromColumns(nums, a, b),
                OperationFactory.fromSymbol(ops.charAt(a)));
    }

    private List<Long> extractNumbersFromColumns(List<String> rows, int a, int b) {
        return rows.stream()
                .flatMap(r -> List.of(r.substring(a, b).trim().split("\\s+")).stream())
                .filter(s -> !s.isBlank())
                .map(Long::parseLong)
                .toList();
    }
}
