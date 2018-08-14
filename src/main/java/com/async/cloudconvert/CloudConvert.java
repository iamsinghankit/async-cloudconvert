package com.async.cloudconvert;

import com.async.cloudconvert.constant.ProcessMode;
import com.async.cloudconvert.service.Process;
import com.async.cloudconvert.service.impl.DefaultProcess;
import org.asynchttpclient.AsyncCompletionHandler;

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


    public Process createSyncProcess(String inputFormat, String outputFormat) {
        return createSyncProcess(inputFormat, outputFormat, DEFAULT_PROCESS_MODE, false);
    }

    public Process createSyncProcessWithMode(String inputFormat, String outputFormat, ProcessMode mode) {
        return createSyncProcess(inputFormat, outputFormat, mode, false);
    }

    public Process createAndStartSyncProcess(String inputFormat, String outputFormat) {
        return createSyncProcess(inputFormat, outputFormat, DEFAULT_PROCESS_MODE, true);
    }

    public Process createAndStartSyncProcessWithMode(String inputFormat, String outputFormat, ProcessMode mode) {
        return createSyncProcess(inputFormat, outputFormat, mode, true);
    }


    public Process createAsyncProcess(String inputFormat, String outputFormat, AsyncCompletionHandler handler) {
        return createAsyncProcess(inputFormat, outputFormat, DEFAULT_PROCESS_MODE, handler, false);
    }

    public Process createAsyncProcessWithMode(String inputFormat, String outputFormat, ProcessMode processMode, AsyncCompletionHandler handler) {
        return createAsyncProcess(inputFormat, outputFormat, processMode, handler, false);
    }


    public Process createAndStartAsyncProcess(String inputFormat, String outputFormat, AsyncCompletionHandler handler) {
        return createAsyncProcess(inputFormat, outputFormat, DEFAULT_PROCESS_MODE, handler, true);
    }

    public Process createAndStartAsyncProcessWithMode(String inputFormat, String outputFormat, ProcessMode processMode, AsyncCompletionHandler handler, boolean startup) {
        return createAsyncProcess(inputFormat, outputFormat, processMode, handler, true);
    }

    private Process createSyncProcess(String inputFormat, String outputFormat, ProcessMode mode, boolean startup) {
        Process process = doCreateProcess(inputFormat, outputFormat, mode);
        if (startup)
            process.start();
        return process;
    }

    private Process createAsyncProcess(String inputFormat, String outputFormat, ProcessMode processMode, AsyncCompletionHandler handler, boolean startup) {
        Process process = doCreateProcess(inputFormat, outputFormat, processMode);
        if (startup)
            process.start(handler);
        return process;
    }

    private Process doCreateProcess(String inputFormat, String outputFormat, ProcessMode processMode) {
        return new DefaultProcess(apiKey, inputFormat, outputFormat, processMode);
    }
}
