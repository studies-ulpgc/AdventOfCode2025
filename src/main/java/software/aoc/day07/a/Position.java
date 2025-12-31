package software.aoc.day07.a;

public record Position(int row, int col) {

    public Position down() {
        return new Position(row + 1, col);
    }

    public Position left() {
        return new Position(row + 1, col - 1);
    }

    public Position right() {
        return new Position(row + 1, col + 1);
    }
}
