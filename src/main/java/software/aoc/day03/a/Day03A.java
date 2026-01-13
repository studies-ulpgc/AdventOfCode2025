package software.aoc.day03.a;

import software.aoc.day03.model.BankParser;
import software.aoc.day03.model.BatteryBank;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public final class Day03A {

    public static void main(String[] args) throws IOException {
        System.out.println(getBanks(getLoader("03-a")).calculateTotalMaximumJoltage());
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
                        .map(BankParser::parseBatteryCellsFromLine)
                        .toList()
        );
    }
}
