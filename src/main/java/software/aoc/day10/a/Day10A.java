package software.aoc.day10.a;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day10A {

    public static void main(String[] args) throws Exception {
        System.out.println("Day10 A: " + getResult());
    }

    private static int getResult() throws IOException {
        return getMachines().stream()
                .mapToInt(getLightSolver()::solve)
                .sum();
    }

    private static LightSolver getLightSolver() {
        return new LightSolver();
    }

    private static List<Machine> getMachines() throws IOException {
        return MachineFactory.parse(getLoader().read());
    }

    private static OrdersLoader getLoader() throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day10-a/orders.txt"))
        );
    }
}
