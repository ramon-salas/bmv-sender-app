/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.Uninterruptibles;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.sajiro.exception.BusinessException;
import mx.com.sajiro.properties.MulticastConfigProperties;
import mx.com.sajiro.util.ArraysUtils;
import mx.com.sajiro.util.MessageHeaderCreatorUtil;

/**
 * @author SAJIRO
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MessageProcessorServiceImpl implements MessageProcessorService {

    private static final String SEQUENCE_NUMBER_KEY = "SeqNum";

    private final MulticastConfigProperties multicastConfigProperties;

    private final MessageValidatorService messageValidatorService;
    private final MessageParserService messageParserService;
    private final MessageTransformerService messageTransformerService;
    private final BytesConverterService bytesConverterService;
    private final BroadcastSenderService broadcastSenderService;

    private final Map<Integer, byte[]> messages = new LinkedHashMap<>();

    @Override
    public void process() throws BusinessException {
        try {
            log.info("Comienza la lectura de los mensajes del archivo: {}",
                    multicastConfigProperties.getPath());
            log.info("Trabajando...");
            readFileLines().forEach(t -> {
                try {
                    manageMessage(t);
                } catch (BusinessException e) {
                    log.error("No se logro enviar el mensaje", e);
                }
            });
        } catch (Exception e) {
            log.error("Se genero un error en el procesamiento de mensajes BMV",
                    e);
            throw new BusinessException(e);
        }
        infoLog();
        Uninterruptibles.sleepUninterruptibly(2600, TimeUnit.MILLISECONDS);
        messages.forEach((sequence, message) -> {
            try {
                sendMessage(message, sequence);
            } catch (BusinessException e) {
                log.error("No se logro enviar el mensaje", e);
            }
        });
    }

    private Stream<String> readFileLines() throws IOException {
        return Files.lines(Paths.get(multicastConfigProperties.getPath()));
    }

    private void manageMessage(final String jsonMessage)
            throws BusinessException {
        if (messageValidatorService.isValidMessage(jsonMessage)) {
            final var jsonObject = messageParserService.parse(jsonMessage);
            if (jsonObjectContainsSeqNum(jsonObject)) {
                final var jsonMessagePropertiesVO = messageTransformerService
                        .transform(jsonObject);
                final var bytes = bytesConverterService.convert(
                        jsonMessagePropertiesVO.getType(),
                        jsonMessagePropertiesVO.getMessage());
                messages.put(jsonMessagePropertiesVO.getSequence(), bytes);
            }
        }
    }

    private boolean jsonObjectContainsSeqNum(final JsonObject jsonObject) {
        return jsonObject.has(SEQUENCE_NUMBER_KEY);
    }

    private void sendMessage(final byte[] message, final int sequence)
            throws BusinessException {
        final var bytes = ArraysUtils.addAll(MessageHeaderCreatorUtil.create(
                multicastConfigProperties, message.length, sequence), message);
        log.info("Sequence: {}", sequence);
        broadcastSenderService.send(bytes);
    }

    private void infoLog() {
        log.info("Mensajes totales a enviar: {}", messages.size());
        log.info("Comienza el envio de mensajes");
        log.info(
                "Datos: Interfaz: {}, IP: {}, Puerto: {}, Grupo Multicast: {}, "
                        + "Sesion: {}, Milisegundos de espera entre mensajes: {}, "
                        + "Mensajes por paquete {}",
                multicastConfigProperties.getSenderInterface(),
                multicastConfigProperties.getIp(),
                multicastConfigProperties.getPort(),
                multicastConfigProperties.getGroup(),
                multicastConfigProperties.getSession(),
                multicastConfigProperties.getMilliseconds(),
                multicastConfigProperties.getTotalMessages());
    }

}
