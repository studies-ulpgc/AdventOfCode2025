package software.aoc.day12;

import java.util.List;

public record Region(int width, int height, List<Integer> quantities) {

    public int area() {
        return width * height;
    }
}
