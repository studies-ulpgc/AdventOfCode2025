package software.aoc.day04;

import software.aoc.io.OrdersLoader;
import java.util.List;

public final class PaperMapFactory {

    public static PaperMap fromLoader(OrdersLoader loader) {
        List<String> grid = loader.read().lines().toList();
        return new PaperMap(grid);
    }
}
