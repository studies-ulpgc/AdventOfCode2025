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

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );

        List<String> lines = Arrays.asList(loader.read().split("\\R"));

        var worksheet = WorksheetParserFactory.createWorksheet()
                .parse(lines);

        System.out.println(worksheet.total());
    }
}
