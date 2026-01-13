package software.aoc.day08.model;

import software.aoc.input.OrdersLoader;

import java.util.List;
import java.util.stream.Collectors;

public interface PointFactory {
    static List<Point> fromCSV(OrdersLoader loader) {
        return loader.read().lines()
                .map(line -> line.split(","))
                .map(arr -> new Point(
                        Integer.parseInt(arr[0]),
                        Integer.parseInt(arr[1]),
                        Integer.parseInt(arr[2])
                ))
                .collect(Collectors.toList());
    }
}
