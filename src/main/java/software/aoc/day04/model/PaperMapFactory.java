package software.aoc.day04.model;

import software.aoc.input.OrdersLoader;
import java.util.List;

public final class PaperMapFactory {

    public static PaperMap createPaperMapFromLoader(OrdersLoader loader) {
        return new PaperMap(readGridLines(loader));
    }

    private static List<String> readGridLines(OrdersLoader loader) {
        return loader.read().lines().toList();
    }
}
