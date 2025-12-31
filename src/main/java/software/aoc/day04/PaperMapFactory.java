package software.aoc.day04;

import software.aoc.io.OrdersLoader;
import java.util.List;

public final class PaperMapFactory {

    public static PaperMap fromLoader(OrdersLoader loader) {
        return new PaperMap(getGrid(loader));
    }

    private static List<String> getGrid(OrdersLoader loader) {
        return loader.read().lines().toList();
    }
}
