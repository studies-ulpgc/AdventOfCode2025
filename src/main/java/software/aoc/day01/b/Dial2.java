package software.aoc.day01.b;

import software.aoc.day01.Order;
import java.util.List;

public final class Dial2 {

    private static final int SIZE = 100;
    private static final int START = 50;

    private final int position;
    private final int zeroCount;

    private Dial2(int position, int zeroCount) {
        this.position = position;
        this.zeroCount = zeroCount;
    }

    public static Dial2 create() {
        return new Dial2(START, 0);
    }

    public Dial2 apply(Order order) {
        int end = normalize(position + order.step());
        int passedZeros = countZerosDuring(position, end, order.step());
        return new Dial2(end, zeroCount + passedZeros);
    }

    public Dial2 execute(List<Order> orders) {
        return orders.stream().reduce(this, Dial2::apply, (a, b) -> b);
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
        int total = Math.abs(step);
        int zeros = 0;
        for (int i = 1; i <= total; i++) {
            int pos = normalize(start + (i * Integer.signum(step)));
            if (pos == 0) zeros++;
        }
        return zeros;
    }
}
