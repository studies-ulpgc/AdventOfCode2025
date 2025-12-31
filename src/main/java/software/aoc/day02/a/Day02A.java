package software.aoc.day02.a;

import software.aoc.day02.GiftShopChecker;
import software.aoc.day02.GiftShopFactory;
import software.aoc.day02.IDRange;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Day02A {

    public static void main(String[] args) throws IOException {
        String day = "02-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(
                        Path.of("src/test/resources/day" + day + "/orders.txt")
                )
        );

        List<IDRange> ranges = GiftShopFactory.fromString(loader.read());
        long result = new GiftShopChecker(new RepeatedTwiceRule())
                .sumInvalidIDs(ranges);

        System.out.println(result);
    }
}
