package software.aoc.day09.a;

import software.aoc.io.OrdersLoader;

import java.util.List;
import java.util.stream.Stream;

public final class PointParser {

    private PointParser() {}

    public static List<Point> fromCSV(OrdersLoader loader) {
        return Stream.of(loader.read().split("\n"))
                .filter(line -> !line.isBlank())
                .map(PointParser::parse)
                .toList();
    }

    private static Point parse(String line) {
        String[] parts = line.split(",");
        return new Point(
                Integer.parseInt(parts[0].trim()),
                Integer.parseInt(parts[1].trim())
        );
    }
}
