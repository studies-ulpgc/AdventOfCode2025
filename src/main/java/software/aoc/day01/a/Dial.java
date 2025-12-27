package software.aoc.day01.a;

import software.aoc.day01.Order;

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

    public Dial apply(Order order) {
        int newPosition = normalize(position + order.step());
        int newCount = zeroCount + (newPosition == 0 ? 1 : 0);
        return new Dial(newPosition, newCount);
    }

    public Dial execute(List<Order> orders) {
        return orders.stream()
                .reduce(this, Dial::apply, (a, b) -> b);
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
}
