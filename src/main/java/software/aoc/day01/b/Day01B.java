package software.aoc.day01.b;

import software.aoc.day01.model.Dial;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;
import software.aoc.day01.model.Order;
import software.aoc.day01.model.OrdersParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Day01B {

    public static void main(String[] args) throws IOException {
        System.out.println("Result: " + getResult(getLoader("01-b")).totalZeros());
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of(
                        "src/test/resources/day" + day + "/orders.txt"))
        );
    }

    private static Dial getResult(OrdersLoader loader) {
        return Dial.create().processOrdersCountingAllIntermediateZeros(getOrders(loader));
    }

    private static List<Order> getOrders(OrdersLoader loader) {
        return OrdersParser.parse(loader.read());
    }
}
