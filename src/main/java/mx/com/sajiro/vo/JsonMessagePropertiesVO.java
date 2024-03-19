/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.vo;

import com.google.gson.JsonObject;

import lombok.Builder;
import lombok.Data;

/**
 * @author SAJIRO
 */
@Data
@Builder
public class JsonMessagePropertiesVO {

    private String type;
    private int sequence;
    private JsonObject message;
}
