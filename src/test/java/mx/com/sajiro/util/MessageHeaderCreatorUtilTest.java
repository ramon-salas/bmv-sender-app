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

import mx.com.sajiro.properties.MulticastConfigProperties;

/**
 * @author SAJIRO
 */
class MessageHeaderCreatorUtilTest {

    private static final int HEADER_LENGTH = 17;

    @Test
    void givenMessage_whenCreateHeder_thenGetBytes() {
        final var bytes = "MESSAGE".getBytes();
        final var result = MessageHeaderCreatorUtil.create(getProperties(),
                bytes.length, 1);
        assertNotNull(bytes);
        assertEquals(HEADER_LENGTH, result.length);
    }

    private MulticastConfigProperties getProperties() {
        final var multicastConfigProperties = new MulticastConfigProperties();
        multicastConfigProperties.setGroup(30);
        multicastConfigProperties.setSession(1);

        return multicastConfigProperties;
    }

}
