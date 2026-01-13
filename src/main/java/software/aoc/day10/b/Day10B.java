package software.aoc.day10.b;

import software.aoc.day10.model.Machine;
import software.aoc.day10.model.MachineLoader;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day10B {

    public static void main(String[] args) throws Exception {
        System.out.println(getResult());
    }

    private static long getResult() throws IOException {
        return getSolver().totalMinimumFlips(getMachines());
    }

    private static VoltageSolver getSolver() {
        return new VoltageSolver();
    }

    private static List<Machine> getMachines() throws IOException {
        return MachineLoader.parseMachinesFromText(getLoader().read());
    }

    private static OrdersLoader getLoader() throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day10-b/orders.txt"))
        );
    }
}