/**
 * SAJIRO 12 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author SAJIRO
 */
@Configuration
@ConfigurationProperties(prefix = "app.conf.multicast")
@Data
public class MulticastConfigProperties {

    /** Absolute path of the messages file. */
    private String path;
    /** Multicast IP. */
    private String ip;
    private int port;
    /** BMV Group. */
    private int group;
    /** BMV session . */
    private int session;
    /** Milliseconds between sends. */
    private long milliseconds;
    /** Network interface. */
    private String senderInterface;
    /** Is the message sequence managed by the application?. */
    private boolean manageSequence;

}
