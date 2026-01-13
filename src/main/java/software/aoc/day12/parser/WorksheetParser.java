package software.aoc.day12.parser;

import software.aoc.day12.model.Region;
import software.aoc.day12.model.Shape;
import software.aoc.day12.model.Worksheet;

import java.util.ArrayList;
import java.util.List;

public class WorksheetParser {
    public Worksheet parse(List<String> lines) {
        List<Shape> shapes = new ArrayList<>();

        return new Worksheet(parseRegions(lines, parseShapes(lines, 0, shapes), new ArrayList<>()), shapes);
    }

    private static List<Region> parseRegions(List<String> lines, int i, List<Region> regions) {
        while (i < lines.size()) {
            i = incrementIndex(i, regions, lines.get(i).trim());
        }
        return regions;
    }

    private static int incrementIndex(int i, List<Region> regions, String line) {
        i++;
        if (line.isBlank()) return i;

        return extractRegion(i, regions, line.split(":"));
    }

    private static int extractRegion(int i, List<Region> regions, String[] parts) {
        if (parts.length < 2) return i;

        return extractRegion(i, regions, parts, getDimensions(parts));
    }

    private static int extractRegion(int i, List<Region> regions, String[] parts, String[] dims) {
        addRegion(regions, getQuantities(parts), new ArrayList<>(), parseIntSafe(dims[0]), parseIntSafe(dims[1]));
        return i;
    }

    private static int parseIntSafe(String dims) {
        return Integer.parseInt(dims);
    }

    private static String[] getDimensions(String[] parts) {
        return parts[0].trim().split("x");
    }

    private static String[] getQuantities(String[] parts) {
        return parts[1].trim().split("\\s+");
    }

    private static void addRegion(List<Region> regions, String[] nums, List<Integer> quantities, int w, int h) {
        for (String n : nums) {
            quantities.add(Integer.parseInt(n));
        }
        regions.add(new Region(w, h, quantities));
    }

    private static int parseShapes(List<String> lines, int i, List<Shape> shapes) {
        while (i < lines.size() && !lines.get(i).contains("x")) {
            String line = lines.get(i).trim();
            if (line.endsWith(":")) {
                i++;
                i = readUntilEmptyOrEnd(lines, i, new ArrayList<>(), shapes);
            }
            i++;
        }
        return i;
    }

    private static int readUntilEmptyOrEnd(List<String> lines, int i, List<String> rows, List<Shape> shapes) {
        while (i < lines.size() && !lines.get(i).isBlank()) {
            rows.add(lines.get(i));
            i++;
        }
        shapes.add(new Shape(rows));
        return i;
    }
}
