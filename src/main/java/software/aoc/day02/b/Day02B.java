package software.aoc.day02.b;

import software.aoc.day02.GiftShopChecker;
import software.aoc.day02.IDRange;
import software.aoc.day02.GiftShopFactory;
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

        List<IDRange> ranges = GiftShopFactory.fromString(loader.read());
        long result = new GiftShopChecker(new RepeatedAtLeastTwiceRule())
                .sumInvalidIDs(ranges);

        System.out.println(result);
    }
}
