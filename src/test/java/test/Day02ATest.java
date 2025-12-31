package test;

import org.junit.Test;
import software.aoc.day02.GiftShopChecker;
import software.aoc.day02.GiftShopFactory;
import software.aoc.day02.IDRange;
import software.aoc.day02.a.RepeatedTwiceRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02ATest {

    private final RepeatedTwiceRule rule = new RepeatedTwiceRule();
    private final GiftShopChecker checker = new GiftShopChecker(rule);

    @Test
    public void given_repeated_digits_should_be_invalid() {
        assertThat(rule.isInvalid(11)).isTrue();
        assertThat(rule.isInvalid(6464)).isTrue();
        assertThat(rule.isInvalid(123123)).isTrue();
    }

    @Test
    public void given_non_repeated_digits_should_be_valid() {
        assertThat(rule.isInvalid(101)).isFalse();
        assertThat(rule.isInvalid(1234)).isFalse();
    }

    @Test
    public void given_range_with_two_invalid_ids_should_sum_both() {
        List<IDRange> ranges = List.of(new IDRange(11, 22));

        long result = checker.sumInvalidIDs(ranges);

        assertThat(result).isEqualTo(33);
    }

    @Test
    public void given_range_with_no_invalid_ids_should_return_zero() {
        List<IDRange> ranges = List.of(new IDRange(1698522, 1698528));

        long result = checker.sumInvalidIDs(ranges);

        assertThat(result).isZero();
    }

    @Test
    public void given_example_from_statement_should_return_expected_sum() {
        String input =
                "11-22,95-115,998-1012,1188511880-1188511890," +
                        "222220-222224,1698522-1698528,446443-446449," +
                        "38593856-38593862";

        List<IDRange> ranges = GiftShopFactory.fromString(input);

        long result = checker.sumInvalidIDs(ranges);

        assertThat(result).isEqualTo(1227775554L);
    }
}
