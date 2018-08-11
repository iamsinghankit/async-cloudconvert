package com.async.cloudconvert.constant;

/**
 * @author Ankit Singh
 */
public enum ProcessMode {
    CONVERT("convert"),INFO("info"),COMBINE("combine"),ARCHIVE("archive"),EXTRACT("extract");

    private String mode;

    ProcessMode(String mode) {
        mode=mode;
    }

    public String getMode(){
        return mode;
    }

}
