package software.aoc.day06.b;

import software.aoc.day06.model.Worksheet;
import software.aoc.day06.parser.WorksheetParserFactory;
import software.aoc.input.FileOrdersLoader;
import software.aoc.input.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day06B {
    public static void main(String[] args) throws IOException {
        System.out.println(getWorksheet("06-b").total());
    }

    private static Worksheet getWorksheet(String day) throws IOException {
        return WorksheetParserFactory.partB()
                .parse(getLoader(day).read());
    }

    private static OrdersLoader getLoader(String day) throws IOException {
        return FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
    }
}
