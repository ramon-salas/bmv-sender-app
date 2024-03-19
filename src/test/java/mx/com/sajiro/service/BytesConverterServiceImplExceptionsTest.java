/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import mx.com.sajiro.exception.MessageConversionException;

/**
 * Unit test - {@link BytesConverterServiceImpl}.
 * 
 * @author SAJIRO
 */
class BytesConverterServiceImplExceptionsTest {

    @Test
    void givenUnkownMessage_whenConvert_thenThrowMessgConversionException() {
        final var messageType = "_";
        assertThrows(MessageConversionException.class,
                () -> new BytesConverterServiceImpl().convert(messageType,
                        null));
    }

}
