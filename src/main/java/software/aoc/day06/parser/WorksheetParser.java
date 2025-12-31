package software.aoc.day06.parser;

import software.aoc.day06.model.Worksheet;

public interface WorksheetParser {
    Worksheet parse(String input);
}
