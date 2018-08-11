package com.async.cloudconvert.service.impl;

import com.async.cloudconvert.CloudConvert;
import com.async.cloudconvert.constant.HttpMethod;
import com.async.cloudconvert.constant.ProcessMode;
import com.async.cloudconvert.http.HttpHandler;
import com.async.cloudconvert.request.Header;
import com.async.cloudconvert.service.Process;
import com.async.cloudconvert.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankit Singh
 */
public class DefaultProcess implements Process {

    private static final String URI = "process";
    private final ProcessMode processMode;
    private final String inputFormat;
    private final String outputFormat;
    private final Header header;
    private HttpHandler httpHandler;

    public DefaultProcess(String apiKey, String inputFormat, String outputFormat, ProcessMode processMode) {
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.processMode = processMode;
        this.header = new Header(apiKey);
        buildProcess();
    }


    private void buildProcess() {
        HttpHandler.Builder builder = new HttpHandler.Builder(CloudConvert.BASE_URL + URI);
        httpHandler = builder.withHeaders(buildHeader()).withBody(buildBody()).build(HttpMethod.POST);
    }

    private Map<String, String> buildHeader() {
        Map<String, String> headers = new HashMap<>();
        headers.put(Header.CONTENT_TYPE, header.getContentType());
        headers.put(Header.AUTHORIZATION, header.getApiKey());
        return headers;
    }

    private String buildBody() {
        Map<String, String> body = new HashMap<>();
        body.put("inputformat", inputFormat);
        body.put("outputformat", outputFormat);
        return JsonUtil.toString(body);
    }

    @Override
    public void start() {
        httpHandler.execute();
    }
}
