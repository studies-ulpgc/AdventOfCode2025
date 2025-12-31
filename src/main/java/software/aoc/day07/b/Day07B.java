package software.aoc.day07.b;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Day07B {

    public static void main(String[] args) throws Exception {
        String day = "07-b";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );

        long result = QuantumSolverFactory.from(loader.read()).solve();
        System.out.println(result);
    }
}
