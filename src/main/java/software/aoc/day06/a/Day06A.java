package software.aoc.day06.a;

import software.aoc.day06.model.Worksheet;
import software.aoc.day06.parser.WorksheetParserFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day06A {
    public static void main(String[] args) throws IOException {
        String day = "06-a";

        System.out.println(getWorksheet(day).total());
    }

    private static Worksheet getWorksheet(String day) throws IOException {
        return WorksheetParserFactory.partA()
                .parse(getLoader(day).read());
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
