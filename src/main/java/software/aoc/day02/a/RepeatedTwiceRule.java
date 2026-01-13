package software.aoc.day02.a;

import software.aoc.day02.model.InvalidIDRule;

import java.util.regex.Pattern;

public final class RepeatedTwiceRule implements InvalidIDRule {

    private static final Pattern PATTERN =
            Pattern.compile("(.+)\\1");

    @Override
    public boolean isInvalid(long id) {
        return PATTERN.matcher(String.valueOf(id)).matches();
    }
}
