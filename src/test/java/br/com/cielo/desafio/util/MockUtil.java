package br.com.cielo.desafio.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class MockUtil {

    private static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T getMockObjectFromJsonFile(String fileName, Class<T> classReference) throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);
        String json = JSONUtils.jsonFromStream(resourceAsStream);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, classReference);
    }
}