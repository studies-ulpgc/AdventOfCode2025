package software.aoc.day02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiftShopFactory {

    public static List<IDRange> fromString(String line) {
        return Arrays.stream(line.split(","))
                .filter(s -> !s.isBlank())
                .map(s -> {
                    String[] parts = s.split("-");
                    return new IDRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
                })
                .collect(Collectors.toList());
    }
}
