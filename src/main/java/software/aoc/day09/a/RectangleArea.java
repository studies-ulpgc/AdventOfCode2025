package software.aoc.day09.a;

public final class RectangleArea {

    private RectangleArea() {}

    public static long between(Point a, Point b) {
        return new Rectangle(a, b).area();
    }
}
