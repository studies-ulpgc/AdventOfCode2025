
package software.aoc.day10.a;

import java.util.List;

public record Machine(
        int size,
        boolean[] targetLights,
        int[] targetVoltages,
        List<Button> buttons
) {
}
