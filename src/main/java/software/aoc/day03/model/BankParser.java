package software.aoc.day03.model;

import java.util.List;

public final class BankParser {

    public static BatteryCells parseBatteryCellsFromLine(String line) {
        return new BatteryCells(extractDigitsFromLine(line));
    }

    private static List<Integer> extractDigitsFromLine(String line) {
        return line.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }
}
