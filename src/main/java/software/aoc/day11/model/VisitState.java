package software.aoc.day11.model;

public record VisitState(boolean seenDac, boolean seenFft) {

    public VisitState visitNode(String node) {
        return new VisitState(
                seenDac || node.equals("dac"),
                seenFft || node.equals("fft")
        );
    }

    public boolean allRequiredNodesVisited() {
        return seenDac && seenFft;
    }
}
