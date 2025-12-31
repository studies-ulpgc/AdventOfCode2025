package software.aoc.day07.a;

public record Beam(Position position) {

    public Beam moveDown() {
        return new Beam(position.down());
    }
}
