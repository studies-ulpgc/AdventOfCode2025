package software.aoc.day02.model;

import java.util.List;
import java.util.stream.LongStream;

public final class GiftShopChecker {

    private final InvalidIDRule rule;

    public GiftShopChecker(InvalidIDRule rule) {
        this.rule = rule;
    }

    public long sumInvalidIDs(List<IDRange> ranges) {
        return ranges.stream()
                .flatMapToLong(this::expandRangeToStreamOfIDs)
                .filter(rule::isInvalid)
                .sum();
    }

    private LongStream expandRangeToStreamOfIDs(IDRange range) {
        return LongStream.rangeClosed(range.start(), range.end());
    }
}
