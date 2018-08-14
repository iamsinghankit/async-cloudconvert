package com.async.cloudconvert.service;

import java.util.Map;

/**
 * @author Ankit Singh
 */
public interface Mapper<R> {
    void set(R t);

    Map getAsMap();



}
