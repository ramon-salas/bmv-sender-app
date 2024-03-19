/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import mx.com.sajiro.exception.BusinessException;
import mx.com.sajiro.service.MessageProcessorService;

/**
 * @author SAJIRO
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args)
            throws BeansException, BusinessException {
        log.info("SAJIRO -> Inicializando envio de mensajes BMV");
        final var applicationContext = SpringApplication.run(Application.class,
                args);
        applicationContext.getBean(MessageProcessorService.class).process();
    }

}
