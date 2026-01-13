package software.aoc.day03.model;

import java.util.List;

public record BatteryBank(List<BatteryCells> banks) {

    public int calculateTotalMaximumJoltage() {
        return (int) calculateTotalMaximumJoltageSelectingDigits(2);
    }

    public long calculateTotalMaximumJoltageSelectingDigits(int selectCount) {
        return banks.stream()
                .mapToLong(bank -> bank.maxJoltage(selectCount))
                .sum();
    }
}
