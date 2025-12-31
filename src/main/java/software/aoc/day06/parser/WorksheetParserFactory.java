package software.aoc.day06.parser;

import software.aoc.day06.a.LeftToRightParser;
import software.aoc.day06.b.RightToLeftParser;

public final class WorksheetParserFactory {

    private WorksheetParserFactory() {}

    public static WorksheetParser partA() {
        return new LeftToRightParser();
    }

    public static WorksheetParser partB() {
        return new RightToLeftParser();
    }
}
