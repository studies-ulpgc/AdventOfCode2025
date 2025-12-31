package software.aoc.day03;

import java.util.ArrayList;
import java.util.List;

public record BatteryBank(List<Integer> cells) {

    public long maxJoltage(int selectCount) {
        List<Integer> subseq = maxSubsequence(cells, selectCount);
        long result = 0L;
        for (int d : subseq) {
            result = result * 10 + d;
        }
        return result;
    }

    private static List<Integer> maxSubsequence(List<Integer> digits, int selectCount) {
        if (digits.isEmpty() || selectCount <= 0) return List.of();
        if (selectCount >= digits.size()) return new ArrayList<>(digits);

        List<Integer> stack = new ArrayList<>();
        int drop = digits.size() - selectCount;
        for (int d : digits) {
            while (!stack.isEmpty() && drop > 0 && stack.get(stack.size() - 1) < d) {
                stack.remove(stack.size() - 1);
                drop--;
            }
            stack.add(d);
        }
        return stack.subList(0, selectCount);
    }
}
