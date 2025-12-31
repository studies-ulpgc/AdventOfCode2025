package software.aoc.day06.a;

import software.aoc.day06.parser.WorksheetParserFactory;
import software.aoc.io.FileOrdersLoader;
import software.aoc.io.OrdersLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day06A {
    public static void main(String[] args) throws IOException {
        String day = "06-a";

        OrdersLoader loader = FileOrdersLoader.from(
                Files.newInputStream(Path.of("src/test/resources/day" + day + "/orders.txt"))
        );
        var worksheet = WorksheetParserFactory.partA()
                .parse(loader.read());

        System.out.println(worksheet.total());
    }
}
