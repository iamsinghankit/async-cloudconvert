package com.async.cloudconvert;

import com.async.cloudconvert.constant.ProcessMode;
import com.async.cloudconvert.service.Process;
import com.async.cloudconvert.service.impl.DefaultProcess;

/**
 * @author Ankit Singh
 */
public final class CloudConvert {
    public static final String BASE_URL = "https://api.cloudconvert.com/";
    private static final ProcessMode DEFAULT_PROCESS_MODE = ProcessMode.CONVERT;

    private String apiKey;


    public CloudConvert(String apiKey) {
        this.apiKey = apiKey;
    }


    public Process createProcess(String inputFormat, String outputFormat) {
        return createSyncProcess(inputFormat, outputFormat, DEFAULT_PROCESS_MODE);
    }

    public Process createProcessWithMode(String inputFormat, String outputFormat, ProcessMode mode) {
        return createSyncProcess(inputFormat, outputFormat, mode);
    }


    private Process createSyncProcess(String inputFormat, String outputFormat, ProcessMode mode) {
        Process process = new DefaultProcess(apiKey, inputFormat, outputFormat, mode);
        process.initialize();
        return process;
    }

}
