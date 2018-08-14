package com.async.cloudconvert.service;

import java.io.Closeable;

/**
 * @author Ankit Singh
 */
public interface Process extends Closeable {

    void start();

}
