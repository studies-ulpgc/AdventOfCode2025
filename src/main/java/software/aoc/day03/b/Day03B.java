package software.aoc.day03.b;

import software.aoc.day03.BankParser;
import software.aoc.day03.BatteryBanks;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public final class Day03B {

    public static void main(String[] args) throws IOException {
        String day = "03-b";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );

        BatteryBanks banks = new BatteryBanks(
                Arrays.stream(loader.read().split("\n"))
                        .map(BankParser::parse)
                        .toList()
        );

        long result = banks.totalMaxJoltage(12);
        System.out.println(result);
    }
}
