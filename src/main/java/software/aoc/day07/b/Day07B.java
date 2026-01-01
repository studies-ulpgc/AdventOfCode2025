package software.aoc.day07.b;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day07B {

    public static void main(String[] args) throws Exception {
        String day = "07-b";

        System.out.println(getResult(day));
    }

    private static long getResult(String day) throws IOException {
        return QuantumSolverFactory.from(getLoader(day).read()).solve();
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
