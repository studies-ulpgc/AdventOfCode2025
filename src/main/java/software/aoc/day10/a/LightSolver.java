package software.aoc.day10.a;

import software.aoc.day10.model.Machine;

public final class LightSolver {

    public int minButtonPressesToTarget(Machine machine) {
        return getBest(machine, machine.buttons().size(), Integer.MAX_VALUE,
                getTargetMask(machine, machine.size(), 0));
    }

    private static int getTargetMask(Machine machine, int nLights, int targetMask) {
        for (int i = 0; i < nLights; i++) {
            if (machine.targetLights()[i]) {
                targetMask |= (1 << i);
            }
        }
        return targetMask;
    }

    private static int getBest(Machine machine, int nButtons, int best, int targetMask) {
        for (int mask = 0; mask < (1 << nButtons); mask++) {
            if (getPresses(mask) >= best) continue;
            if (getLights(machine, nButtons, mask, 0) == targetMask) {
                best = getPresses(mask);
            }
        }
        return best;
    }

    private static int getPresses(int mask) {
        return Integer.bitCount(mask);
    }

    private static int getLights(Machine machine, int nButtons, int mask, int lights) {
        for (int b = 0; b < nButtons; b++) {
            if ((mask & (1 << b)) != 0) {
                for (int idx : machine.buttons().get(b).affects()) {
                    lights ^= (1 << idx);
                }
            }
        }
        return lights;
    }
}
