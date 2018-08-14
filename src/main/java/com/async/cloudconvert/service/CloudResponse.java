package com.async.cloudconvert.service;

import java.util.Map;

/**
 * @author Ankit Singh
 */
public interface CloudResponse<R> {

    Map getAsMap();

    String getAsString();

    <T> T getAs(Class<T> clazz);


}
