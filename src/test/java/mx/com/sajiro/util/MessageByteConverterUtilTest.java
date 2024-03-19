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

import com.google.gson.JsonParser;

import mx.com.sajiro.bmv.EventsSystemEncoder;
import mx.com.sajiro.exception.EncoderException;
import mx.com.sajiro.vo.SystemEventVO;

/**
 * Unit test - {@link MessageByteConverterUtil}.
 * 
 * @author SAJIRO
 */
class MessageByteConverterUtilTest {

    private static final int MESSAGE_HEADER_LENGTH = 2;

    @Test
    void givenMessage_whenTransfor_thenGetBytes() throws EncoderException {
        final var jsonMessage = "{\"Name\":\"System Event\",\"Type\":\"S\",\"Instrument Number\":5,\"Event Code\":\"A\",\"Market\":\"L\",\"Sending Time\":1111,\"Ending Time\":2222}";
        final var jsonObject = JsonParser.parseString(jsonMessage)
                .getAsJsonObject();
        final var bytes = MessageByteConverterUtil.convertToBytes(jsonObject,
                SystemEventVO.class, EventsSystemEncoder.BLOCK_LENGTH);
        assertNotNull(bytes);
        assertEquals(EventsSystemEncoder.BLOCK_LENGTH + MESSAGE_HEADER_LENGTH,
                bytes.length);
    }

}
