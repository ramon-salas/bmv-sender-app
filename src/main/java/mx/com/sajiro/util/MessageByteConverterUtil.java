/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.util;

import java.nio.ByteBuffer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;
import mx.com.sajiro.api.IEncoder;
import mx.com.sajiro.bmv.impl.EncoderImpl;
import mx.com.sajiro.exception.EncoderException;

/**
 * @author SAJIRO
 */
@Slf4j
public final class MessageByteConverterUtil {

    private MessageByteConverterUtil() {
    }

    private static final IEncoder<Character> ENCODER = new EncoderImpl();

    public static byte[] convertToBytes(final JsonObject locObj,
            final Class<?> clazz, final int messageLength)
            throws EncoderException {
        final String messageString = new Gson().fromJson(locObj, clazz)
                .toString();
        final byte[] byteResult = ENCODER.encode(messageString);
        final ByteBuffer headerBlock = ByteBuffer.allocate(2);
        headerBlock.clear();
        headerBlock.putShort((short) messageLength);
        headerBlock.flip();
        return ArraysUtils.addAll(headerBlock.array(), byteResult);
    }

}
