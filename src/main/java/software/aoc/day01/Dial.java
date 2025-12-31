package software.aoc.day01;

import java.util.List;

public final class Dial {

    private static final int SIZE = 100;
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

    public Dial apply_left_pointing(Order order) {
        return new Dial(getNormalize(order), getCount(getNormalize(order)));
    }

    private int getNormalize(Order order) {
        return normalize(position + order.step());
    }

    private int getCount(int newPosition) {
        return zeroCount + (newPosition == 0 ? 1 : 0);
    }

    public Dial execute_left_pointing(List<Order> orders) {
        return orders.stream()
                .reduce(this, Dial::apply_left_pointing, (a, b) -> b);
    }

    public Dial apply_any_click(Order order) {
        return new Dial(getNormalize(order), zeroCount + getCountZerosDuring(order, getNormalize(order)));
    }

    private int getCountZerosDuring(Order order, int end) {
        return countZerosDuring(position, end, order.step());
    }

    public Dial execute_any_click(List<Order> orders) {
        return orders.stream().reduce(this, Dial::apply_any_click, (a, b) -> b);
    }

    public int position() {
        return position;
    }

    public int count() {
        return zeroCount;
    }

    private static int normalize(int value) {
        return ((value % SIZE) + SIZE) % SIZE;
    }

    private static int countZerosDuring(int start, int end, int step) {
        if (step == 0) return 0;
        return getZeros(start, step, Math.abs(step), 0);
    }

    private static int getZeros(int start, int step, int total, int zeros) {
        for (int i = 1; i <= total; i++) {
            if (getNormalize(start, step, i) == 0) zeros++;
        }
        return zeros;
    }

    private static int getNormalize(int start, int step, int i) {
        return normalize(start + (i * Integer.signum(step)));
    }
}
