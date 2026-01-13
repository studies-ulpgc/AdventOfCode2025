package software.aoc.day07.model;

public record Beam(Position position) {

    public Beam moveDown() {
        return new Beam(position.down());
    }
}
