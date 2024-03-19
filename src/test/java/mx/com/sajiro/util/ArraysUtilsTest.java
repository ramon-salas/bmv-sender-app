/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test - {@link ArraysUtils}.
 * 
 * @author SAJIRO
 */
class ArraysUtilsTest {

    @Test
    void givenTowByteArrays_whenMix_thenGetBytes() {
        final var array1 = "Message".getBytes();
        final var array2 = "BMV".getBytes();
        final var result = ArraysUtils.addAll(array1, array2);
        assertNotNull(result);
        assertEquals(array1.length + array2.length, result.length);
    }

}
