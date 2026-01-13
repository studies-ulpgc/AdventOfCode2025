package test;

import org.junit.Test;
import software.aoc.day03.model.BatteryBank;
import software.aoc.day03.model.BankParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03ATest {
    @Test
    public void given_example_input_should_compute_total_max_joltage() {
        List<String> lines = List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        );

        BatteryBank banks = new BatteryBank(
                lines.stream().map(BankParser::parseBatteryCellsFromLine).toList()
        );

        assertThat(banks.calculateTotalMaximumJoltage()).isEqualTo(357);
    }
}

