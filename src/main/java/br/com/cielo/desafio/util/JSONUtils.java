package br.com.cielo.desafio.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class JSONUtils {

    private static final Logger log = LoggerFactory.getLogger(JSONUtils.class);

    private JSONUtils() {
    }

    public static String jsonFromStream(InputStream inputStream) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) != -1)
                outputStream.write(buffer, 0, length);
            return outputStream.toString(StandardCharsets.UTF_8.toString());
        } catch (IOException e) {
            log.error("Ocorreu um erro ao tentar obter os dados do Stream.", e);
            return null;
        }
    }
}
