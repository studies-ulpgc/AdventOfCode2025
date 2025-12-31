package software.aoc.day10.a;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class MachineFactory {

    private static final Pattern LIGHTS = Pattern.compile("\\[(.*?)\\]");
    private static final Pattern BUTTON = Pattern.compile("\\((.*?)\\)");
    private static final Pattern VOLTAGE = Pattern.compile("\\{(.*?)\\}");

    public static List<Machine> parse(String input) {
        return input.lines()
                .filter(l -> !l.isBlank())
                .map(MachineFactory::parseLine)
                .toList();
    }

    private static Machine parseLine(String line) {
        boolean[] lights = parseLights(line);
        List<Button> buttons = parseButtons(line);
        int[] voltages = parseVoltages(line);

        return new Machine(
                lights.length,
                lights,
                voltages,
                buttons
        );
    }

    private static boolean[] parseLights(String line) {
        Matcher m = LIGHTS.matcher(line);
        if (!m.find()) throw new IllegalArgumentException();

        char[] chars = m.group(1).toCharArray();
        boolean[] result = new boolean[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i] == '#';
        }
        return result;
    }

    private static List<Button> parseButtons(String line) {
        Matcher m = BUTTON.matcher(line);
        List<Button> buttons = new ArrayList<>();

        while (m.find()) {
            String content = m.group(1);
            Set<Integer> indices = Arrays.stream(content.split(","))
                    .filter(s -> !s.isBlank())
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            buttons.add(new Button(indices));
        }
        return buttons;
    }

    private static int[] parseVoltages(String line) {
        Matcher m = VOLTAGE.matcher(line);
        if (!m.find()) return new int[0];

        return Arrays.stream(m.group(1).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
