package software.aoc.day03;

import java.util.List;

public record BatteryBanks(List<BatteryBank> banks) {

    public int totalMaxJoltage() {
        return (int) totalMaxJoltage(2);
    }

    public long totalMaxJoltage(int selectCount) {
        return banks.stream()
                .mapToLong(bank -> bank.maxJoltage(selectCount))
                .sum();
    }
}
