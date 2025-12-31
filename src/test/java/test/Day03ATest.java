package test;

import org.junit.Test;
import software.aoc.day03.BatteryCells;
import software.aoc.day03.BatteryBank;
import software.aoc.day03.BankParser;
import software.aoc.io.OrdersLoader;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03ATest {

    @Test
    public void given_single_bank_should_compute_max_joltage() {
        BatteryCells bank = BankParser.parse("987654321111111");
        assertThat(bank.maxJoltage(2)).isEqualTo(98);
    }

    @Test
    public void given_example_input_should_compute_total_max_joltage() {
        List<String> lines = List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        );

        BatteryBank banks = new BatteryBank(
                lines.stream().map(BankParser::parse).toList()
        );

        assertThat(banks.totalMaxJoltage()).isEqualTo(357);
    }

    @Test
    public void given_loader_input_should_compute_total_max_joltage() {
        OrdersLoader fakeLoader = () ->
                "987654321111111\n" +
                        "811111111111119\n" +
                        "234234234234278\n" +
                        "818181911112111";

        BatteryBank banks = new BatteryBank(
                Arrays.stream(fakeLoader.read().split("\n"))
                        .map(BankParser::parse)
                        .toList()
        );

        assertThat(banks.totalMaxJoltage()).isEqualTo(357);
    }

    @Test
    public void given_empty_bank_should_return_zero() {
        BatteryCells bank = BankParser.parse("");
        assertThat(bank.maxJoltage(2)).isEqualTo(0);

        BatteryBank banks = new BatteryBank(List.of(bank));
        assertThat(banks.totalMaxJoltage()).isEqualTo(0);
    }
}

