package software.aoc.day12;

import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day12A {
    public static void main(String[] args) throws IOException {
        String day = "12";

        System.out.println(getResult(day));
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
