package com.async.cloudconvert.service;

import java.io.Closeable;
import java.io.File;

/**
 * @author Ankit Singh
 */
public interface Process extends Closeable {
    void initialize();

    Conversion startConversion(File inputFile);

}
