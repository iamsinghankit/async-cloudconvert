package com.async.cloudconvert.http;

/**
 * @author Ankit Singh
 */
public interface Http {
    <T> void requestAsync(T t);

    <T> T requestSync();
}
