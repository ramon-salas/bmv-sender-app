/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.JsonParser;

import mx.com.sajiro.exception.BusinessException;

/**
 * Unit test - {@link BytesConverterServiceImpl}.
 * 
 * @author SAJIRO
 */
class BytesConverterServiceImplTest {

    private static final String JSON_MESSAGE_TEST_FILE = "jsonMessage.txt";

    static Stream<Arguments> initParametrizableTest() throws IOException {
        final var arguments = new ArrayList<Arguments>();
        try (var reader = new BufferedReader(new InputStreamReader(
                BytesConverterServiceImplTest.class.getClassLoader()
                        .getResourceAsStream(JSON_MESSAGE_TEST_FILE)))) {
            reader.lines().forEach(line -> {
                final var messageSplitted = line.split(";");
                arguments.add(
                        Arguments.of(messageSplitted[0], messageSplitted[1]));
            });
        }
        return arguments.stream();
    }

    @ParameterizedTest
    @MethodSource("initParametrizableTest")
    void givenMessage_whenConvert_thenGentBytes(final String type,
            final String message) throws BusinessException {
        final var jsonObject = JsonParser.parseString(message)
                .getAsJsonObject();
        final var result = new BytesConverterServiceImpl().convert(type,
                jsonObject);
        assertNotNull(result);
    }

}
