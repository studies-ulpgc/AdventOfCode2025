package test;

import org.junit.Test;
import software.aoc.day03.BatteryCells;
import software.aoc.day03.BatteryBank;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03BTest {

    @Test
    public void given_example_input_should_compute_total_max_joltage() {
        List<String> lines = List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        );

        BatteryBank banks = new BatteryBank(
                lines.stream()
                        .map(line -> new BatteryCells(line.chars().map(Character::getNumericValue).boxed().toList()))
                        .toList()
        );

        long result = banks.totalMaxJoltage(12);
        assertThat(result).isEqualTo(3_121_910_778_619L);
    }
}
