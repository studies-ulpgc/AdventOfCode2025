package software.aoc.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileOrdersLoader implements OrdersLoader {

    private final InputStream input;

    private FileOrdersLoader(InputStream input) {
        this.input = input;
    }

    public static OrdersLoader from(InputStream input) {
        return new FileOrdersLoader(input);
    }

    @Override
    public String read() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
