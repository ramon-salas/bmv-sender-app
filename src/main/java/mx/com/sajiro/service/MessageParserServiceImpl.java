/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author SAJIRO
 */
@Service
public class MessageParserServiceImpl implements MessageParserService {

    /*
     * (non-Javadoc)
     * @see mx.com.sajiro.service.MessageParserService#parse(java.lang.String).
     */
    @Override
    public JsonObject parse(final String jsonMessage) {
        return JsonParser.parseString(formatJsonMessage(jsonMessage))
                .getAsJsonObject();
    }

    private String formatJsonMessage(final String jsonMessage) {
        if (jsonMessage.startsWith(",")) {
            return jsonMessage.substring(1);
        }

        return jsonMessage;
    }

}
