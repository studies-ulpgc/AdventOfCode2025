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
        int sign = line.charAt(0) == 'L' ? -1 : 1;
        int value = Integer.parseInt(line.substring(1));
        return new Order(sign * value);
    }
}
