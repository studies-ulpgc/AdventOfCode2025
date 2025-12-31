package software.aoc.day03.a;

import software.aoc.day03.BankParser;
import software.aoc.day03.BatteryBanks;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public final class Day03A {

    public static void main(String[] args) throws IOException {
        String day = "03-a";

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

        int result = banks.totalMaxJoltage();
        System.out.println(result);
    }
}
