/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import org.springframework.stereotype.Service;

/**
 * @author SAJIRO
 */
@Service
public class MessageValidatorServiceImpl implements MessageValidatorService {

    /** the recover word key. */
    private static final String RECOVERY_WORD_KEY = "RECOVERY";

    /*
     * (non-Javadoc)
     * @see
     * mx.com.sajiro.service.MessageValidator#isValidMessage(java.lang.String).
     */
    @Override
    public boolean isValidMessage(final String jsonMessage) {
        return !jsonMessage.contains(RECOVERY_WORD_KEY);
    }

}
