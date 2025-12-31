package software.aoc.day12;

import java.util.ArrayList;
import java.util.List;

public class WorksheetParser {
    public Worksheet parse(List<String> lines) {
        List<Shape> shapes = new ArrayList<>();
        List<Region> regions = new ArrayList<>();

        int i = 0;
        // 1. Parsear Shapes
        while (i < lines.size() && !lines.get(i).contains("x")) {
            String line = lines.get(i).trim();
            if (line.endsWith(":")) {
                i++;
                List<String> rows = new ArrayList<>();
                // Leer filas hasta encontrar una línea vacía o el fin de la lista
                while (i < lines.size() && !lines.get(i).isBlank()) {
                    rows.add(lines.get(i));
                    i++;
                }
                shapes.add(new Shape(rows));
            }
            i++;
        }

        // 2. Parsear Regions
        while (i < lines.size()) {
            String line = lines.get(i).trim();
            i++;
            if (line.isBlank()) continue;

            String[] parts = line.split(":");
            if (parts.length < 2) continue;

            String[] dims = parts[0].trim().split("x");
            int w = Integer.parseInt(dims[0]);
            int h = Integer.parseInt(dims[1]);

            // Usamos \\s+ para manejar múltiples espacios entre números
            String[] nums = parts[1].trim().split("\\s+");
            List<Integer> quantities = new ArrayList<>();
            for (String n : nums) {
                quantities.add(Integer.parseInt(n));
            }
            regions.add(new Region(w, h, quantities));
        }

        return new Worksheet(regions, shapes);
    }
}
