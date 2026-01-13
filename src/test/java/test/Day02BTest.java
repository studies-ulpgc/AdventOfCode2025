package test;

import org.junit.Test;
import software.aoc.day02.model.GiftShopChecker;
import software.aoc.day02.model.GiftShopFactory;
import software.aoc.day02.model.IDRange;
import software.aoc.day02.b.RepeatedAtLeastTwiceRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02BTest {

    private final RepeatedAtLeastTwiceRule rule =
            new RepeatedAtLeastTwiceRule();

    private final GiftShopChecker checker =
            new GiftShopChecker(rule);

    @Test
    public void given_example_from_statement_should_return_expected_sum() {
        String input =
                "11-22,95-115,998-1012,1188511880-1188511890," +
                        "222220-222224,1698522-1698528,446443-446449," +
                        "38593856-38593862,565653-565659,824824821-824824827," +
                        "2121212118-2121212124";

        List<IDRange> ranges = GiftShopFactory.parseIDRangesFromString(input);

        long result = checker.sumInvalidIDs(ranges);

        assertThat(result).isEqualTo(4174379265L);
    }
}
