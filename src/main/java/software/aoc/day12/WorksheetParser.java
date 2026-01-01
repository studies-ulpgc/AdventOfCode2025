package software.aoc.day12;

import java.util.ArrayList;
import java.util.List;

public class WorksheetParser {
    public Worksheet parse(List<String> lines) {
        List<Shape> shapes = new ArrayList<>();

        return new Worksheet(parsear_regions(lines, parsear_shapes(lines, 0, shapes), new ArrayList<>()), shapes);
    }

    private static List<Region> parsear_regions(List<String> lines, int i, List<Region> regions) {
        while (i < lines.size()) {
            i = getI(i, regions, lines.get(i).trim());
            continue;
        }
        return regions;
    }

    private static int getI(int i, List<Region> regions, String line) {
        i++;
        if (line.isBlank()) return i;

        return extracted(i, regions, line.split(":"));
    }

    private static int extracted(int i, List<Region> regions, String[] parts) {
        if (parts.length < 2) return i;

        return extracted(i, regions, parts, getDims(parts));
    }

    private static int extracted(int i, List<Region> regions, String[] parts, String[] dims) {
        adding_to_regions(regions, getNums(parts), new ArrayList<>(), getParseInt(dims[0]), getParseInt(dims[1]));
        return i;
    }

    private static int getParseInt(String dims) {
        return Integer.parseInt(dims);
    }

    private static String[] getDims(String[] parts) {
        return parts[0].trim().split("x");
    }

    private static String[] getNums(String[] parts) {
        return parts[1].trim().split("\\s+");
    }

    private static void adding_to_regions(List<Region> regions, String[] nums, List<Integer> quantities, int w, int h) {
        for (String n : nums) {
            quantities.add(Integer.parseInt(n));
        }
        regions.add(new Region(w, h, quantities));
    }

    private static int parsear_shapes(List<String> lines, int i, List<Shape> shapes) {
        while (i < lines.size() && !lines.get(i).contains("x")) {
            String line = lines.get(i).trim();
            if (line.endsWith(":")) {
                i++;
                i = leer_hasta_encontrar_linea_vacia_o_final(lines, i, new ArrayList<>(), shapes);
            }
            i++;
        }
        return i;
    }

    private static int leer_hasta_encontrar_linea_vacia_o_final(List<String> lines, int i, List<String> rows, List<Shape> shapes) {
        while (i < lines.size() && !lines.get(i).isBlank()) {
            rows.add(lines.get(i));
            i++;
        }
        shapes.add(new Shape(rows));
        return i;
    }
}
