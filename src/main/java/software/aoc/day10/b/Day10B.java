package software.aoc.day10.b;

import software.aoc.day10.a.Machine;
import software.aoc.day10.a.MachineFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day10B {

    public static void main(String[] args) throws Exception {
        // Cargamos el input usando tu infraestructura existente
        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day10-b/orders.txt"))
        );

        // Parseamos las máquinas (aprovechando el MachineFactory de la Parte A)
        List<Machine> machines = MachineFactory.parse(loader.read());

        // Instanciamos el nuevo solver de voltajes
        VoltageSolver solver = new VoltageSolver();

        // Resolvemos calculando el total de pulsaciones para todas las máquinas
        long result = solver.solveAll(machines);

        System.out.println("Day10 B: " + result);
    }
}