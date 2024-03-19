/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.util;

/**
 * @author SAJIRO
 */
public final class ArraysUtils {

    private ArraysUtils() {
    }

    public static byte[] addAll(final byte[] array1, final byte[] array2) {
        var result = new byte[array1.length + array2.length];
        addBytesToResult(array1, result);
        addBytesToResult(array2, result);

        return result;
    }

    private static void addBytesToResult(final byte[] array,
            final byte[] result) {
        System.arraycopy(array, 0, result, 0, array.length);
    }

}
