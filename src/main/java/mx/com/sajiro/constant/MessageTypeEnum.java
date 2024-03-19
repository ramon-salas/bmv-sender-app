/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.constant;

import java.util.Map;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import mx.com.sajiro.exception.MessageTypeNotFoundException;

/**
 * @author SAJIRO
 */
@AllArgsConstructor
public enum MessageTypeEnum {

    /** the status changes type. */
    STATUS_CHANGES_TYPE("4"),
    /** the wighted average price type. */
    WEIGHTED_AVERAGE_PRICE_TYPE("M"),
    /** the capital trades type. */
    CAPITAL_TRADES_TYPE("P"),
    /** the registry operations type. */
    REGISTRY_OPERATIONS_TYPE("Z"),
    /** the system event type. */
    SYSTEM_EVENT_TYPE("S"),
    /** the provable allocation price. */
    PROBABLE_ALLOCATION_PRICE("2"),
    /** the middle price existing quots. */
    MIDDLE_PRICE_EXISTING_QUOTES("5"),
    /** the tradability. */
    TRADABILITY("E"),
    /** the best offer. */
    BEST_OFFER("O"),
    /** the virtual trade. */
    VIRTUAL_TRADE("V"),
    /** the mutal fund trades. */
    MUTUAL_FUNDS_TRADES("Y");

    private final String value;

    private static Map<String, MessageTypeEnum> map;

    public static MessageTypeEnum find(final String value)
            throws MessageTypeNotFoundException {
        final MessageTypeEnum messageType = getMap().get(value);
        if (null == messageType) {
            throw new MessageTypeNotFoundException(
                    "No existe el mensaje: " + value);
        }
        return messageType;
    }

    private static Map<String, MessageTypeEnum> getMap() {
        if (null == map) {
            map = new TreeMap<>();
            for (final MessageTypeEnum messageType : values()) {
                map.put(messageType.value, messageType);
            }
        }
        return map;
    }

}
