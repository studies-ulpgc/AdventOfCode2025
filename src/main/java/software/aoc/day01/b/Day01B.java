package software.aoc.day01.b;

import software.aoc.day01.Order;
import software.aoc.day01.OrdersParser;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Day01B {

    public static void main(String[] args) throws IOException {
        String day = "01-b";
        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of(
                        "src/test/resources/day"+ day +"/orders.txt"))
        );
        List<Order> orders = OrdersParser.parse(loader.read());
        Dial2 result = Dial2.create().execute(orders);
        System.out.println("Final position: " + result.position());
        System.out.println("Zeros during rotation: " + result.count());
    }
}
