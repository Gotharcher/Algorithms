package Yandex.Algo_course;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Sprint1DTests {
    private final InputStream systemIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("2" + System.lineSeparator() + "-1 -10", "1"),
                Arguments.of("5" + System.lineSeparator() + "1 2 5 4 8", "2"),
                Arguments.of("7"  + System.lineSeparator() + "-1 -10 -8 0 2 0 5", "3"),
                Arguments.of("7"  + System.lineSeparator() + "0 0 0 0 0 0 0", "0")
        );
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void para_test(String args, String ans) throws IOException {
        provideInput(args);
        Sprint1D.main(new String[0]);
        assertEquals(ans, outputStream.toString().trim());
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
        System.setOut(standardOut);
    }
}