/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Service unit test - {@link MessageParserServiceImpl}.
 * 
 * @author SAJIRO
 */
class MessageParserServiceImplTest {

    @Test
    void givenJsonMessage_whenParse_thenGetJsonObject() {
        final var jsonMessage = "{\"seqNum\":7, \"Message\":{\"Name\":\"Securiti Suspension\",\"Type\":\"K\",\"Instrument Number\":5,\"Date for Suspension\":1707424818,\"Negotiation State\":\"O\",\"Reason\":\"O\"}}";
        assertNotNull(new MessageParserServiceImpl().parse(jsonMessage));
    }

    @Test
    void givenJsonMessage_whenJsonInitWithComma_thenGetJsonObject() {
        final var jsonMessage = ",{\"seqNum\":7, \"Message\":{\"Name\":\"Securiti Suspension\",\"Type\":\"K\",\"Instrument Number\":5,\"Date for Suspension\":1707424818,\"Negotiation State\":\"O\",\"Reason\":\"O\"}}";
        assertNotNull(new MessageParserServiceImpl().parse(jsonMessage));
    }

}
