package software.aoc.day02.a;

import software.aoc.day02.model.GiftShopChecker;
import software.aoc.day02.model.GiftShopFactory;
import software.aoc.day02.model.IDRange;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Day02A {

    public static void main(String[] args) throws IOException {
        System.out.println(getResult(parseIDRangesFromLoader(getLoader("02-a"))));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );
    }

    private static long getResult(List<IDRange> ranges) {
        return new GiftShopChecker(new RepeatedTwiceRule())
                .sumInvalidIDs(ranges);
    }

    private static List<IDRange> parseIDRangesFromLoader(OrdersLoader loader) {
        return GiftShopFactory.parseIDRangesFromString(loader.read());
    }
}
