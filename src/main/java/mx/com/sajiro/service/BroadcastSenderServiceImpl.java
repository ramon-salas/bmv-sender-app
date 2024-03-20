/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.Uninterruptibles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.sajiro.exception.BroadcastSenderException;
import mx.com.sajiro.exception.BusinessException;
import mx.com.sajiro.properties.MulticastConfigProperties;

/**
 * @author SAJIRO
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BroadcastSenderServiceImpl implements BroadcastSenderService {

    private final MulticastConfigProperties multicastConfigProperties;
    private final SentMessageHandlerService sentMessageHandlerService;

    /*
     * (non-Javadoc)
     * @see mx.com.sajiro.service.BroadcastSenderService#send(byte[]).
     */
    @Override
    public void send(final byte[] message) throws BusinessException {
        try {
            final var networkInterface = NetworkInterface
                    .getByName(multicastConfigProperties.getSenderInterface());
            final var intetAddress = networkInterface.getInetAddresses();
            final var inetSocketAddress = new InetSocketAddress(
                    intetAddress.nextElement(), 0);
            try (var datagramSocket = new DatagramSocket(inetSocketAddress)) {
                datagramSocket.setBroadcast(Boolean.TRUE);
                final var datagramPacket = new DatagramPacket(message,
                        message.length,
                        InetAddress
                                .getByName(multicastConfigProperties.getIp()),
                        multicastConfigProperties.getPort());
                datagramSocket.send(datagramPacket);
                Uninterruptibles.sleepUninterruptibly(
                        multicastConfigProperties.getMilliseconds(),
                        TimeUnit.MICROSECONDS);
                log.info("Mensaje enviado: {}", Arrays.toString(message));
                sentMessageHandlerService.check();
            }
        } catch (Exception e) {
            throw new BroadcastSenderException(e);
        }
    }

}
