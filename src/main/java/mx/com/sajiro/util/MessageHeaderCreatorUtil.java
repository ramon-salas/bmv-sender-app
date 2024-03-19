/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.util;

import java.nio.ByteBuffer;

import mx.com.sajiro.properties.MulticastConfigProperties;

/**
 * @author SAJIRO
 */
public final class MessageHeaderCreatorUtil {

    private MessageHeaderCreatorUtil() {
    }

    private static final short HEADER_LENGTH = 17;
    private static final int TOTAL_MESSAGES = 1;

    public static byte[] create(final MulticastConfigProperties properties,
            final int messageLength, final int sequence) {
        final var byteBuffer = ByteBuffer.allocate(HEADER_LENGTH);
        byteBuffer.clear();
        byteBuffer.putShort((short) (messageLength + HEADER_LENGTH));
        byteBuffer.put((byte) TOTAL_MESSAGES);
        byteBuffer.put((byte) properties.getGroup());
        byteBuffer.put((byte) properties.getSession());
        byteBuffer.putInt(sequence);
        byteBuffer.putLong(System.currentTimeMillis());
        byteBuffer.flip();

        final byte[] headerBytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(headerBytes);

        return headerBytes;
    }

}
