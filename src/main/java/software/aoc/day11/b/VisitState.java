package software.aoc.day11.b;

public record VisitState(boolean seenDac, boolean seenFft) {

    public VisitState visit(String node) {
        return new VisitState(
                seenDac || node.equals("dac"),
                seenFft || node.equals("fft")
        );
    }

    public boolean isValidAtEnd() {
        return seenDac && seenFft;
    }
}
