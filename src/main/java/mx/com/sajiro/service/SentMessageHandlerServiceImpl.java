/**
 * SAJIRO 19 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.Uninterruptibles;

import lombok.RequiredArgsConstructor;
import mx.com.sajiro.properties.MulticastConfigProperties;

/**
 * @author SAJIRO
 */
@Service
@RequiredArgsConstructor
public class SentMessageHandlerServiceImpl
        implements SentMessageHandlerService {

    private final MulticastConfigProperties multicastConfigProperties;

    private int messageCounter;

    /*
     * (non-Javadoc)
     * @see mx.com.sajiro.service.SentMessageHandlerService#check().
     */
    @Override
    public void check() {
        increaseCounter();
        if (isMessageCounterInTheLimit()) {
            restartCounter();
            sleepProcess();
        }
    }

    private void increaseCounter() {
        messageCounter++;
    }

    private boolean isMessageCounterInTheLimit() {
        return messageCounter >= multicastConfigProperties.getTotalMessages();
    }

    private void restartCounter() {
        messageCounter = 0;
    }

    private void sleepProcess() {
        Uninterruptibles.sleepUninterruptibly(
                multicastConfigProperties.getMilliseconds(),
                TimeUnit.MILLISECONDS);
    }

}
