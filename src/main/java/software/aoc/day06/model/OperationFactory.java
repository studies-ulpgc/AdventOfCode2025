package software.aoc.day06.model;

public final class OperationFactory {

    private OperationFactory() {}

    public static Operation fromSymbol(char symbol) {
        return switch (symbol) {
            case '+' -> new Addition();
            case '*' -> new Multiplication();
            default -> throw new IllegalArgumentException(
                    "Unknown operation: " + symbol
            );
        };
    }
}
