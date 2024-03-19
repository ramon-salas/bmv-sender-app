/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.google.gson.JsonParser;

import mx.com.sajiro.properties.MulticastConfigProperties;

/**
 * Service unit test - {@link MessageTransformerServiceImpl}.
 * 
 * @author SAJIRO
 */
class MessageTransformerServiceImplTest {

    @Test
    void givenMessageJsonObject_whenTransform_thenGetVO() {
        validateMessage(properties -> {
            properties.setManageSequence(Boolean.FALSE);
            return properties;
        });
    }

    @Test
    void givenMessageJsonObject_whenTransformWithSequence_thenGetVO() {
        validateMessage(properties -> {
            properties.setManageSequence(Boolean.TRUE);
            return properties;
        });
    }

    private void validateMessage(
            final Function<MulticastConfigProperties, MulticastConfigProperties> configProperties) {
        final var jsonMessage = "{\"SeqNum\":7,\"Message\":{\"Name\":\"Securiti Suspension\",\"Type\":\"K\",\"Instrument Number\":5,\"Date for Suspension\":1707424818,\"Negotiation State\":\"O\",\"Reason\":\"O\"}}";
        final var messageTransformerService = new MessageTransformerServiceImpl();
        final var multicastConfigProperties = configProperties
                .apply(new MulticastConfigProperties());
        ReflectionTestUtils.setField(messageTransformerService,
                "multicastConfigProperties", multicastConfigProperties);
        final var result = messageTransformerService.transform(
                JsonParser.parseString(jsonMessage).getAsJsonObject());
        assertNotNull(result);
        assertAll(() -> assertNotNull(result.getType()),
                () -> assertThat(result.getSequence()),
                () -> assertNotNull(result.getMessage()));
    }

}
