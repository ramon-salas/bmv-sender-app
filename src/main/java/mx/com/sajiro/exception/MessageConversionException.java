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
public class MessageConversionException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = -7309781270528302697L;

    public MessageConversionException(final CharSequence message) {
        super(message);
    }

    public MessageConversionException(final Throwable cause) {
        super(cause);
    }

    public MessageConversionException(final CharSequence message,
            final Throwable cause) {
        super(message, cause);
    }

}
