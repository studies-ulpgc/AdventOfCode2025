package software.aoc.day07.a;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Day07A {

    public static void main(String[] args) throws Exception {
        String day = "07-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );

        int result = TachyonSolverFactory.from(loader.read()).solve();
        System.out.println(result);
    }
}
