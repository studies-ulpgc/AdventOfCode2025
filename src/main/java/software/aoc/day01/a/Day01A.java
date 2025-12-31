package software.aoc.day01.a;

import software.aoc.day01.Dial;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;
import software.aoc.day01.Order;
import software.aoc.day01.OrdersParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Day01A {

    public static void main(String[] args) throws IOException {
        String day = "01-a";

        System.out.println("Zeros during rotation: " + getResult(getLoader(day)).count());
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of(
                        "src/test/resources/day" + day + "/orders.txt"))
        );
    }

    private static Dial getResult(OrdersLoader loader) {
        return Dial.create().execute_left_pointing(getOrders(loader));
    }

    private static List<Order> getOrders(OrdersLoader loader) {
        return OrdersParser.parse(loader.read());
    }
}
