package software.aoc.day01.a;

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
        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of(
                        "src/test/resources/day"+ day +"/orders.txt"))
        );
        List<Order> orders = OrdersParser.parse(loader.read());
        Dial result = Dial.create().execute(orders);
        System.out.println("Final position: " + result.position());
        System.out.println("Zeros during rotation: " + result.count());
    }
}
