package software.aoc.day10.a;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day10A {

    public static void main(String[] args) throws Exception {
        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day10-a/orders.txt"))
        );

        List<Machine> machines = MachineFactory.parse(loader.read());

        LightSolver solver = new LightSolver();

        int result = machines.stream()
                .mapToInt(solver::solve)
                .sum();

        System.out.println("Day10 A: " + result);
    }
}
