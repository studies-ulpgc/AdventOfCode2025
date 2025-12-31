package software.aoc.day03;

import java.util.List;

public final class BankParser {

    public static BatteryBank parse(String line) {
        return new BatteryBank(digitsOf(line));
    }

    private static List<Integer> digitsOf(String line) {
        return line.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }
}
