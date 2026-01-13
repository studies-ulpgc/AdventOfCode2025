package software.aoc.day12;

import software.aoc.day12.model.Worksheet;
import software.aoc.day12.parser.WorksheetParserFactory;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day12 {
    public static void main(String[] args) throws IOException {
        System.out.println(getResult("12"));
    }

    private static long getResult(String day) throws IOException {
        return getWorksheet(day).total();
    }

    private static Worksheet getWorksheet(String day) throws IOException {
        return WorksheetParserFactory.createWorksheet()
                .parse(getLines(day));
    }

    private static List<String> getLines(String day) throws IOException {
        return Arrays.asList(getLoader(day).read().split("\\R"));
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
