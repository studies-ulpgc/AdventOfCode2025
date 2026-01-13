package software.aoc.day03.model;

import java.util.ArrayList;
import java.util.List;

public record BatteryCells(List<Integer> cells) {

    public long maxJoltage(int selectCount) {
        List<Integer> subseq = maxSubsequence(cells, selectCount);
        long result = 0;
        for (int d : subseq) {
            result = result * 10 + d;
        }
        return result;
    }

    private static List<Integer> maxSubsequence(List<Integer> digits, int selectCount) {
        if (digits.isEmpty() || selectCount <= 0) return List.of();
        if (selectCount >= digits.size()) return new ArrayList<>(digits);

        List<Integer> stack = new ArrayList<>();
        buildMaxSubsequenceWithStack(digits, stack, getDrop(digits, selectCount));
        return stack.subList(0, selectCount);
    }

    private static int getDrop(List<Integer> digits, int selectCount) {
        return digits.size() - selectCount;
    }

    private static void buildMaxSubsequenceWithStack(List<Integer> digits, List<Integer> stack, int drop) {
        for (int d : digits) {
            while (!stack.isEmpty() && drop > 0 && stack.get(stack.size() - 1) < d) {
                stack.remove(stack.size() - 1);
                drop--;
            }
            stack.add(d);
        }
    }
}
