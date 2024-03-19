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
public class BusinessException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -8137898786119617467L;

    public BusinessException(final CharSequence message) {
        super(message.toString());
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }

    public BusinessException(final CharSequence message,
            final Throwable cause) {
        super(message.toString(), cause);
    }

}
