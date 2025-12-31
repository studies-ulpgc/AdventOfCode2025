package software.aoc.day01;

import java.util.Arrays;
import java.util.List;

public final class OrdersParser {

    private OrdersParser() {}

    public static List<Order> parse(String input) {
        return Arrays.stream(input.split("\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(OrdersParser::parseLine)
                .toList();
    }

    private static Order parseLine(String line) {
        return new Order(getSign(line) * getParsedInt(line));
    }

    private static int getSign(String line) {
        return line.charAt(0) == 'L' ? -1 : 1;
    }

    private static int getParsedInt(String line) {
        return Integer.parseInt(line.substring(1));
    }
}
