/**
 * SAJIRO 19 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import org.junit.jupiter.api.Test;

import mx.com.sajiro.properties.MulticastConfigProperties;

/**
 * Unit test - {@link SentMessageHandlerServiceImpl}.
 * 
 * @author SAJIRO
 */
class SentMessageHandlerServiceImplTest {

    @Test
    void givenMessage_whenReachedLimit_thenSleep() {
        final var sentMessageHandlerService = new SentMessageHandlerServiceImpl(
                createProperties());
        sendMessaes(3, sentMessageHandlerService);

    }

    private MulticastConfigProperties createProperties() {
        final var multicastConfigProperties = new MulticastConfigProperties();
        multicastConfigProperties.setTotalMessages(2);
        multicastConfigProperties.setMilliseconds(1);

        return multicastConfigProperties;
    }

    private void sendMessaes(final int totalMessages,
            final SentMessageHandlerServiceImpl service) {
        for (var i = 0; i < totalMessages; i++) {
            service.check();
        }
    }

}
