/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import mx.com.sajiro.properties.MulticastConfigProperties;
import mx.com.sajiro.vo.JsonMessagePropertiesVO;

/**
 * @author SAJIRO
 */
@Service
public class MessageTransformerServiceImpl
        implements MessageTransformerService {

    private static final String MESSAGE_KEY = "Message";
    private static final String TYPE_KEY = "Type";
    private static final String SEQUENCE_NUMBER_KEY = "SeqNum";

    @Autowired
    private MulticastConfigProperties multicastConfigProperties;

    private int sequenceGlobal = 0;

    /*
     * (non-Javadoc)
     * @see
     * mx.com.sajiro.service.MessageTransformerService#transform(com.google.gson
     * .JsonObject).
     */
    @Override
    public JsonMessagePropertiesVO transform(
            final JsonObject messageJsonObject) {
        final var messageObject = messageJsonObject
                .getAsJsonObject(MESSAGE_KEY);
        return JsonMessagePropertiesVO.builder().message(messageObject)
                .type(messageObject.get(TYPE_KEY).getAsString())
                .sequence(getSequence(messageJsonObject)).build();
    }

    private int getSequence(final JsonObject rootObj) {
        final int sequence;
        if (multicastConfigProperties.isManageSequence()) {
            sequence = sequenceGlobal++;
        } else {
            sequence = rootObj.get(SEQUENCE_NUMBER_KEY).getAsInt();
        }

        return sequence;
    }

}
