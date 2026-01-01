package software.aoc.day09.a;

import software.aoc.day09.Point;
import software.aoc.day09.Rectangle;

public final class RectangleArea {

    private RectangleArea() {}

    public static long between(Point a, Point b) {
        return new Rectangle(a, b).area();
    }
}
