package software.aoc.day07.a;

import software.aoc.day07.Position;

public record Beam(Position position) {

    public Beam moveDown() {
        return new Beam(position.down());
    }
}
