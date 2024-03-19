/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.exception;

/**
 * @author SAJIRO
 */
public class BroadcastSenderException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 5667742937077849005L;

    public BroadcastSenderException(final CharSequence message) {
        super(message);
    }

    public BroadcastSenderException(final Throwable cause) {
        super(cause);
    }

    public BroadcastSenderException(final CharSequence message,
            final Throwable cause) {
        super(message, cause);
    }

}
