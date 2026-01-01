package software.aoc.day10.b;

import software.aoc.day10.a.Machine;
import software.aoc.day10.a.MachineFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day10B {

    public static void main(String[] args) throws Exception {
        System.out.println("Day10 B: " + getResult());
    }

    private static long getResult() throws IOException {
        return getSolver().solveAll(getMachines());
    }

    private static VoltageSolver getSolver() {
        return new VoltageSolver();
    }

    private static List<Machine> getMachines() throws IOException {
        return MachineFactory.parse(getLoader().read());
    }

    private static OrdersLoader getLoader() throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day10-b/orders.txt"))
        );
    }
}