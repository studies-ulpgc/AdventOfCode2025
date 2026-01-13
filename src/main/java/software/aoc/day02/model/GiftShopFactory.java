package software.aoc.day02.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GiftShopFactory {

    public static List<IDRange> parseIDRangesFromString(String line) {
        return Arrays.stream(line.split(","))
                .filter(s -> !s.isBlank())
                .map(getStringIDRangeFunction())
                .collect(Collectors.toList());
    }

    private static Function<String, IDRange> getStringIDRangeFunction() {
        return s -> {
            String[] parts = s.split("-");
            return new IDRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
        };
    }
}
