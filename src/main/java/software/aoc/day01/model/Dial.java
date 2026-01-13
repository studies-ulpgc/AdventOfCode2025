package software.aoc.day01.model;

import java.util.List;

public final class Dial {
    private static final int DIAL_SIZE = 100;
    private static final int START = 50;

    private final int position;
    private final int zeroCount;

    private Dial(int position, int zeroCount) {
        this.position = position;
        this.zeroCount = zeroCount;
    }

    public static Dial create() {
        return new Dial(START, 0);
    }

    public Dial applyLeftPointing(Order order) {
        return new Dial(getNormalizedPosition(order),
                incrementZeroCounterIfFinalPositionIsZero(
                        getNormalizedPosition(order)));
    }

    public Dial processOrdersCountingOnlyFinalZero(List<Order> orders) {
        return orders.stream()
                .reduce(this, Dial::applyLeftPointing, (a, b) -> b);
    }

    private int getNormalizedPosition(Order order) {
        return normalize(position + order.step());
    }

    private int incrementZeroCounterIfFinalPositionIsZero(int newPosition) {
        return zeroCount + (newPosition == 0 ? 1 : 0);
    }

    public Dial applyAnyClick(Order order) {
        return new Dial(getNormalizedPosition(order), zeroCount + countZerosCrossedDuringMovement(order, getNormalizedPosition(order)));
    }

    private int countZerosCrossedDuringMovement(Order order, int end) {
        return countZerosBetweenPositions(position, end, order.step());
    }

    public Dial processOrdersCountingAllIntermediateZeros(List<Order> orders) {
        return orders.stream().reduce(this, Dial::applyAnyClick, (a, b) -> b);
    }

    public int position() {
        return position;
    }

    public int totalZeros() {
        return zeroCount;
    }

    private static int normalize(int value) {
        return ((value % DIAL_SIZE) + DIAL_SIZE) % DIAL_SIZE;
    }

    private static int countZerosBetweenPositions(int start, int end, int step) {
        if (step == 0) return 0;
        return countZeroHitsWhileMoving(start, step, Math.abs(step), 0);
    }

    private static int countZeroHitsWhileMoving(int start, int step, int total, int zeros) {
        for (int i = 1; i <= total; i++) {
            if (getNormalizedPosition(start, step, i) == 0) zeros++;
        }
        return zeros;
    }

    private static int getNormalizedPosition(int start, int step, int i) {
        return normalize(start + (i * Integer.signum(step)));
    }
}
