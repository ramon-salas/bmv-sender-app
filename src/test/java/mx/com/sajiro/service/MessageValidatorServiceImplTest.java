/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Service unit test - {@link MessageValidatorServiceImpl}.
 * 
 * @author SAJIRO
 */
class MessageValidatorServiceImplTest {

    @Test
    void givenJsonMessage_whenMessageCorrect_thenTrue() {
        final var jsonMessage = "{\"seqNum\":7, \"Message\":{\"Name\":\"Securiti Suspension\",\"Type\":\"K\",\"Instrument Number\":5,\"Date for Suspension\":1707424818,\"Negotiation State\":\"O\",\"Reason\":\"O\"}}";
        assertTrue(
                new MessageValidatorServiceImpl().isValidMessage(jsonMessage));
    }

    @Test
    void givenJsonMessage_whenMessageContainsErrorWord_thenFalse() {
        final var jsonMessage = "{\"RECOVERY\"}";
        assertFalse(
                new MessageValidatorServiceImpl().isValidMessage(jsonMessage));
    }

}
