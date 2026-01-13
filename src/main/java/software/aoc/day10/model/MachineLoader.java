package software.aoc.day10.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class MachineLoader {

    private static final Pattern LIGHTS = Pattern.compile("\\[(.*?)\\]");
    private static final Pattern BUTTON = Pattern.compile("\\((.*?)\\)");
    private static final Pattern VOLTAGE = Pattern.compile("\\{(.*?)\\}");

    public static List<Machine> parseMachinesFromText(String input) {
        return input.lines()
                .filter(l -> !l.isBlank())
                .map(MachineLoader::parseLine)
                .toList();
    }

    private static Machine parseLine(String line) {
        return new Machine(
                parseTargetLights(line).length,
                parseTargetLights(line),
                parseTargetVoltages(line),
                parseButtonsFromLine(line)
        );
    }

    private static boolean[] parseTargetLights(String line) {
        Matcher m = LIGHTS.matcher(line);
        if (!m.find()) throw new IllegalArgumentException();
        return getBooleans(getCharArray(m), getResult(m));
    }

    private static boolean[] getResult(Matcher m) {
        return new boolean[getCharArray(m).length];
    }

    private static char[] getCharArray(Matcher m) {
        return m.group(1).toCharArray();
    }

    private static boolean[] getBooleans(char[] chars, boolean[] result) {
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i] == '#';
        }
        return result;
    }

    private static List<Button> parseButtonsFromLine(String line) {
        return getButtons(BUTTON.matcher(line), new ArrayList<>());
    }

    private static List<Button> getButtons(Matcher m, List<Button> buttons) {
        while (m.find()) {
            Set<Integer> indices = Arrays.stream(m.group(1).split(","))
                    .filter(s -> !s.isBlank())
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            buttons.add(new Button(indices));
        }
        return buttons;
    }

    private static int[] parseTargetVoltages(String line) {
        Matcher m = VOLTAGE.matcher(line);
        if (!m.find()) return new int[0];

        return Arrays.stream(m.group(1).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
