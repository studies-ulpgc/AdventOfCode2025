package software.aoc.day03.a;

import software.aoc.day03.BankParser;
import software.aoc.day03.BatteryBank;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public final class Day03A {

    public static void main(String[] args) throws IOException {
        String day = "03-a";

        System.out.println(getBanks(getLoader(day)).totalMaxJoltage());
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );
    }

    private static BatteryBank getBanks(OrdersLoader loader) {
        return new BatteryBank(
                Arrays.stream(loader.read().split("\n"))
                        .map(BankParser::parse)
                        .toList()
        );
    }
}
