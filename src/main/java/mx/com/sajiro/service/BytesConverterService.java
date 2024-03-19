/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import com.google.gson.JsonObject;

import mx.com.sajiro.exception.BusinessException;

/**
 * @author SAJIRO
 */
public interface BytesConverterService {

    byte[] convert(String type, JsonObject locObj) throws BusinessException;

}
