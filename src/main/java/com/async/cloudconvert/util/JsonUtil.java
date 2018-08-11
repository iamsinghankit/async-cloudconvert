package com.async.cloudconvert.util;

import com.async.cloudconvert.exception.RuntimeExceptionWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ankit Singh
 */
public abstract class JsonUtil {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static <T> String toString(T t) {
        return RuntimeExceptionWrapper.wrap(() -> mapper.writeValueAsString(t));
    }

    public static <T> T toReference(String o, Class<T> clazz) {
        return RuntimeExceptionWrapper.wrap(() -> mapper.readValue(o, clazz));
    }

}
