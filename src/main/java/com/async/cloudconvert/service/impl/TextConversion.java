package com.async.cloudconvert.service.impl;

import com.async.cloudconvert.service.CloudResponse;
import com.async.cloudconvert.service.Conversion;

import java.io.File;

/**
 * @author Ankit Singh
 */
public class TextConversion implements Conversion {
    private CloudResponse cloudResponse;
    private File inputFile;

    public TextConversion(CloudResponse cloudResponse, File inputFile) {
        this.cloudResponse = cloudResponse;
        this.inputFile = inputFile;
    }

    @Override
    public void convert() {

    }
}
