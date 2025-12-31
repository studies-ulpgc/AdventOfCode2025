package software.aoc.day10.a;

public final class LightSolver {

    public int solve(Machine machine) {
        int nButtons = machine.buttons().size();
        int nLights = machine.size();

        int targetMask = 0;
        for (int i = 0; i < nLights; i++) {
            if (machine.targetLights()[i]) {
                targetMask |= (1 << i);
            }
        }

        int best = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << nButtons); mask++) {
            int lights = 0;
            int presses = Integer.bitCount(mask);

            if (presses >= best) continue;

            for (int b = 0; b < nButtons; b++) {
                if ((mask & (1 << b)) != 0) {
                    for (int idx : machine.buttons().get(b).affects()) {
                        lights ^= (1 << idx);
                    }
                }
            }

            if (lights == targetMask) {
                best = presses;
            }
        }

        return best;
    }
}
