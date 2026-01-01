package software.aoc.day10.b;

import software.aoc.day10.a.Machine;
import software.aoc.day10.a.Button;
import java.util.*;

public final class VoltageSolver {

    public long solveAll(List<Machine> machines) {
        return getTotal(machines, 0);
    }

    private long getTotal(List<Machine> machines, long total) {
        for (Machine m : machines) {
            total += solveMachine(m);
        }
        return total;
    }

    private long solveMachine(Machine machine) {
        return findMinFlips(getTarget(machine, new ArrayList<>()),
                getAllParityMaps(getCounters(machine), machine.buttons()), new HashMap<>());
    }

    private static int getCounters(Machine machine) {
        return machine.targetVoltages().length;
    }

    private static List<Integer> getTarget(Machine machine, List<Integer> target) {
        for (int v : machine.targetVoltages()) target.add(v);
        return target;
    }

    private Map<List<Integer>, Map<List<Integer>, Integer>> getAllParityMaps(int nCounters, List<Button> buttons) {
        return getMap(nCounters, buttons, buttons.size(), new HashMap<>());
    }

    private static Map<List<Integer>, Map<List<Integer>, Integer>> getMap(int nCounters, List<Button> buttons, int nButtons, Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps) {
        for (int i = 0; i < (1 << nButtons); i++) {
            getParity(buttons, nButtons, parityMaps, i, getResult(nCounters));
        }
        return parityMaps;
    }

    private static void getParity(List<Button> buttons, int nButtons,
                                  Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps, int i, List<Integer> result) {
        int setBits = getSetBits(buttons, nButtons, i, 0, result);

        List<Integer> parity = getIntegers(result, new ArrayList<>());

        parityMaps.putIfAbsent(parity, new HashMap<>());
        Map<List<Integer>, Integer> internal = parityMaps.get(parity);

        if (!internal.containsKey(result) || internal.get(result) > setBits) {
            internal.put(result, setBits);
        }
    }

    private static ArrayList<Integer> getResult(int nCounters) {
        return new ArrayList<>(Collections.nCopies(nCounters, 0));
    }

    private static int getSetBits(List<Button> buttons, int nButtons, int i, int setBits, List<Integer> result) {
        for (int j = 0; j < nButtons; j++) {
            if ((i & (1 << j)) != 0) {
                setBits = getSetBits(buttons, setBits, j, result);
            }
        }
        return setBits;
    }

    private static int getSetBits(List<Button> buttons, int setBits, int j, List<Integer> result) {
        setBits++;
        for (int counterIdx : buttons.get(j).affects()) {
            result.set(counterIdx, result.get(counterIdx) + 1);
        }
        return setBits;
    }

    private long findMinFlips(List<Integer> current,
                              Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps,
                              Map<List<Integer>, Long> cache) {

        if (cache.containsKey(current)) return cache.get(current);
        if (isZero(current, true)) return 0;
        if (getMaxValue(current) != null) return getMaxValue(current);
        if (!parityMaps.containsKey(getIntegers(current, new ArrayList<>()))) return Long.MAX_VALUE;

        return getFlips(current, parityMaps, cache, Long.MAX_VALUE);
    }

    private long getFlips(List<Integer> current, Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps, Map<List<Integer>, Long> cache, long minFlips) {
        minFlips = getMinFlips(current, parityMaps, cache, minFlips);
        cache.put(current, minFlips);
        return minFlips;
    }

    private long getMinFlips(List<Integer> current, Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps, Map<List<Integer>, Long> cache, long minFlips) {
        return getMinFlips(current, parityMaps, cache, getIntegers(current, new ArrayList<>()), minFlips);
    }

    private static List<Integer> getIntegers(List<Integer> current, List<Integer> currentParity) {
        for (int v : current) currentParity.add(v % 2);
        return currentParity;
    }

    private static Long getMaxValue(List<Integer> current) {
        for (int v : current) if (v < 0) return Long.MAX_VALUE;
        return null;
    }

    private static boolean isZero(List<Integer> current, boolean allZero) {
        for (int v : current) {
            if (v != 0) { allZero = false; break; }
        }
        return allZero;
    }

    private long getMinFlips(List<Integer> current, Map<List<Integer>, Map<List<Integer>, Integer>> parityMaps, Map<List<Integer>, Long> cache, List<Integer> currentParity, long minFlips) {
        for (Map.Entry<List<Integer>, Integer> entry : parityMaps.get(currentParity).entrySet()) {
            if (!isValid(current, getPattern(entry), true)) continue;

            if (findMinFlips(add_next(current, new ArrayList<>(), getPattern(entry)), parityMaps, cache) != Long.MAX_VALUE) {
                minFlips = Math.min(minFlips, getFlips(entry) + 2 * findMinFlips(add_next(current,
                        new ArrayList<>(), getPattern(entry)), parityMaps, cache));
            }
        }
        return minFlips;
    }

    private static List<Integer> getPattern(Map.Entry<List<Integer>, Integer> entry) {
        return entry.getKey();
    }

    private static Integer getFlips(Map.Entry<List<Integer>, Integer> entry) {
        return entry.getValue();
    }

    private static List<Integer> add_next(List<Integer> current, List<Integer> next, List<Integer> pattern) {
        for (int i = 0; i < current.size(); i++) {
            next.add((current.get(i) - pattern.get(i)) / 2);
        }
        return next;
    }

    private static boolean isValid(List<Integer> current, List<Integer> pattern, boolean valid) {
        for (int i = 0; i < pattern.size(); i++) {
            if (pattern.get(i) > current.get(i)) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}