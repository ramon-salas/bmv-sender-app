/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.exception;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test - {@link BroadcastSenderException}.
 * 
 * @author SAJIRO
 */
class BroadcastSenderExceptionTest {

    @Test
    void givenExceptionMessage_whenThrowException_thenGiveMessage() {
        final var exception = new BroadcastSenderException("Error");
        try {
            throw exception;
        } catch (BusinessException e) {
            assertEquals("Error", e.getMessage());
        }
    }

    @Test
    void givenCuaseException_whenThrowException_thenGiveCause() {
        final var exception = new BroadcastSenderException(
                new NullPointerException());
        try {
            throw exception;
        } catch (BusinessException e) {
            assertTrue(e.getCause() instanceof NullPointerException);
        }
    }

    @Test
    void givenMessageAndCauseException_whenThrowException_thenGiveMessageAndCause() {
        final var exception = new BroadcastSenderException("Error",
                new NullPointerException());
        try {
            throw exception;
        } catch (BusinessException e) {
            assertAll(() -> assertEquals("Error", e.getMessage()),
                    () -> assertTrue(
                            e.getCause() instanceof NullPointerException));
        }
    }

}
