package software.aoc.day09.b;

import software.aoc.day09.a.Point;

import java.util.List;

public final class PolygonFactory {

    private PolygonFactory() {}

    public static Polygon fromRedLoop(List<Point> points) {
        return new Polygon(points);
    }
}
