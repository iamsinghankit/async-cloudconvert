package com.async.cloudconvert;

import com.async.cloudconvert.constant.ProcessMode;
import com.async.cloudconvert.service.Process;
import com.async.cloudconvert.service.impl.DefaultProcess;

/**
 * @author Ankit Singh
 */
public final class CloudConvert {
    public static final String BASE_URL = "https://api.cloudconvert.com/";
    private final ProcessMode DEFAULT_PROCESS_MODE=ProcessMode.CONVERT;

    private String apiKey;

    public CloudConvert(String apiKey){
        this.apiKey=apiKey;
    }

    public Process createProcess(String inputFormat,String outputFormat){
        return doCreateProcess(inputFormat,outputFormat,DEFAULT_PROCESS_MODE,false);
    }

    public Process createProcess(String inputFormat, String outputFormat, ProcessMode mode){
       return doCreateProcess(inputFormat,outputFormat,mode,false);
    }

    public Process createAndStartProcess(String inputFormat,String outputFormat){
        return doCreateProcess(inputFormat,outputFormat,DEFAULT_PROCESS_MODE,true);
    }
    public Process createAndStartProcess(String inputFormat,String outputFormat,ProcessMode processMode){
        return doCreateProcess(inputFormat,outputFormat,processMode,true);
    }

    private Process doCreateProcess(String inputFormat,String outputFormat,ProcessMode mode, boolean startup){
        Process process=new DefaultProcess(apiKey,inputFormat,outputFormat,mode);
        if(startup)
            process.start();
        return process;
    }
}
