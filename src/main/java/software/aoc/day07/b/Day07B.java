package software.aoc.day07.b;

import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Day07B {

    public static void main(String[] args) throws Exception {
        System.out.println(getResult("07-b"));
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
