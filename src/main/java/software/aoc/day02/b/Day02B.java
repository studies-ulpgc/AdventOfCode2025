package software.aoc.day02.b;

import software.aoc.day02.GiftShopChecker;
import software.aoc.day02.IDRange;
import software.aoc.day02.GiftShopFactory;
import software.aoc.day02.a.RepeatedTwiceRule;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Day02B {

    public static void main(String[] args) throws IOException {
        String day = "02-b";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );

        System.out.println(getResult(getRanges(getLoader(day))));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );
    }

    private static long getResult(List<IDRange> ranges) {
        return new GiftShopChecker(new RepeatedAtLeastTwiceRule())
                .sumInvalidIDs(ranges);
    }

    private static List<IDRange> getRanges(OrdersLoader loader) {
        return GiftShopFactory.fromString(loader.read());
    }
}
