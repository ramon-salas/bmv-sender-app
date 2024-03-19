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
public class MessageTypeNotFoundException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 3486911534803271770L;

    public MessageTypeNotFoundException(final CharSequence message) {
        super(message);
    }

    public MessageTypeNotFoundException(final Throwable cause) {
        super(cause);
    }

    public MessageTypeNotFoundException(final CharSequence message,
            final Throwable cause) {
        super(message, cause);
    }

}
