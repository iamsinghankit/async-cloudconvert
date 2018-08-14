package com.async.cloudconvert.service;

import org.asynchttpclient.AsyncCompletionHandler;

import java.io.Closeable;
import java.util.Optional;

/**
 * @author Ankit Singh
 */
public interface Process extends Closeable {

    void start(AsyncCompletionHandler handler);

    void start();

    Optional<CloudResponse> getResponse();

    void close(String url);

}
