package software.aoc.day10.b;

import software.aoc.day10.a.Machine;
import software.aoc.day10.a.Button;
import java.util.*;

public final class VoltageSolver {

    public long solveAll(List<Machine> machines) {
        long total = 0;
        for (Machine m : machines) {
            total += solveMachine(m);
        }
        return total;
    }

    private long solveMachine(Machine machine) {
        int nCounters = machine.targetVoltages().length;
        List<Button> buttons = machine.buttons();

        // Generamos todos los mapas de paridad posibles (2^n_botones)
        // Esto mapea una configuración de paridad (0s y 1s) al mínimo de pulsaciones para lograrla
        Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps = getAllParityMaps(nCounters, buttons);

        // Cache para memorización: Estado (lista de voltajes actuales) -> Mínimo de pulsaciones
        Map<List<Integer>, Long> cache = new HashMap<>();

        List<Integer> target = new ArrayList<>();
        for (int v : machine.targetVoltages()) target.add(v);

        return findMinFlips(target, parityMaps, cache);
    }

    private Map<List<Integer>, Map<List<Integer>, Integer>> getAllParityMaps(int nCounters, List<Button> buttons) {
        Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps = new HashMap<>();
        int nButtons = buttons.size();

        // Probamos todas las combinaciones de pulsar cada botón 0 o 1 vez
        for (int i = 0; i < (1 << nButtons); i++) {
            List<Integer> result = new ArrayList<>(Collections.nCopies(nCounters, 0));
            int setBits = 0;
            for (int j = 0; j < nButtons; j++) {
                if ((i & (1 << j)) != 0) {
                    setBits++;
                    for (int counterIdx : buttons.get(j).affects()) {
                        result.set(counterIdx, result.get(counterIdx) + 1);
                    }
                }
            }

            List<Integer> parity = new ArrayList<>();
            for (int val : result) parity.add(val % 2);

            parityMaps.putIfAbsent(parity, new HashMap<>());
            Map<List<Integer>, Integer> internal = parityMaps.get(parity);

            if (!internal.containsKey(result) || internal.get(result) > setBits) {
                internal.put(result, setBits);
            }
        }
        return parityMaps;
    }

    private long findMinFlips(List<Integer> current,
                              Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps,
                              Map<List<Integer>, Long> cache) {

        if (cache.containsKey(current)) return cache.get(current);

        // Caso base: todos los contadores en cero
        boolean allZero = true;
        for (int v : current) {
            if (v != 0) { allZero = false; break; }
        }
        if (allZero) return 0;

        // Si algún contador es negativo, es inválido
        for (int v : current) if (v < 0) return Long.MAX_VALUE;

        // Paridad actual
        List<Integer> currentParity = new ArrayList<>();
        for (int v : current) currentParity.add(v % 2);

        if (!parityMaps.containsKey(currentParity)) return Long.MAX_VALUE;

        long minFlips = Long.MAX_VALUE;

        for (Map.Entry<List<Integer>, Integer> entry : parityMaps.get(currentParity).entrySet()) {
            List<Integer> pattern = entry.getKey();
            int nFlips = entry.getValue();

            // Verificar si el patrón cabe en el objetivo actual
            boolean valid = true;
            for (int i = 0; i < pattern.size(); i++) {
                if (pattern.get(i) > current.get(i)) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            // Siguiente estado: (actual - patrón) / 2
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < current.size(); i++) {
                next.add((current.get(i) - pattern.get(i)) / 2);
            }

            long res = findMinFlips(next, parityMaps, cache);
            if (res != Long.MAX_VALUE) {
                minFlips = Math.min(minFlips, nFlips + 2 * res);
            }
        }

        cache.put(current, minFlips);
        return minFlips;
    }
}