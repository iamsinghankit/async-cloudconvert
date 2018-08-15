package com.async.cloudconvert.service.impl;

import com.async.cloudconvert.CloudConvert;
import com.async.cloudconvert.constant.DocumentFormat;
import com.async.cloudconvert.constant.ProcessMode;
import com.async.cloudconvert.http.HttpHandler;
import com.async.cloudconvert.http.HttpMethod;
import com.async.cloudconvert.request.Header;
import com.async.cloudconvert.service.CloudResponse;
import com.async.cloudconvert.service.Conversion;
import com.async.cloudconvert.service.Process;
import com.async.cloudconvert.util.JsonUtil;
import com.async.cloudconvert.util.ObjectUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Ankit Singh
 */
public class DefaultProcess implements Process {

    private static final String URI = "process";
    private final String inputFormat;
    private final String outputFormat;
    private final Header header;
    private CloudResponse response;

    public DefaultProcess(String apiKey, String inputFormat, String outputFormat, ProcessMode processMode) {
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.header = new Header(apiKey, processMode);
    }


    @Override
    public void initialize() {
        if (Objects.nonNull(response)) {
            close();
            response=null;
        }
        HttpHandler httpHandler = buildProcess();
        response = new DefaultResponse(httpHandler.execute());
    }

    @Override
    public Conversion startConversion(File inputFile) {
        if(Objects.isNull(response))
            throw new RuntimeException("Please initialize the process first");
        return transform(inputFile);
    }

    @Override
    public void close() {
        delete((String) response.getAsMap().get("url"));
    }

    private Conversion transform(File inputFile){
        if(ObjectUtil.getExtension(inputFile.getName()).equalsIgnoreCase(inputFormat))
            throw new RuntimeException("Invalid File. Please provide "+inputFormat+" format");
        return doTransform(inputFile);
    }

    private Conversion doTransform(File inputFile){
        if(Objects.nonNull(DocumentFormat.valueOf(inputFormat.toUpperCase())))
            return new TextConversion(response,inputFile);
        throw new UnsupportedOperationException("Only Document Allowed for conversion");
    }

    private HttpHandler buildProcess() {
        HttpHandler.Builder builder = new HttpHandler.Builder(CloudConvert.BASE_URL + URI);
        return builder.withHeaders(buildHeader()).withBody(buildBody()).build(HttpMethod.POST);
    }

    private Map<String, String> buildHeader() {
        Map<String, String> headers = new HashMap<>();
        headers.put(Header.CONTENT_TYPE, header.getContentType());
        headers.put(Header.AUTHORIZATION, header.getApiKey());
        headers.put(Header.MODE, header.getProcessMode().getMode());
        return headers;
    }

    private String buildBody() {
        Map<String, String> body = new HashMap<>();
        body.put("inputformat", inputFormat);
        body.put("outputformat", outputFormat);
        return JsonUtil.toString(body);
    }


    private void delete(String url) {
        HttpHandler handler = new HttpHandler.Builder("https:" + url).build(HttpMethod.DELETE);
        handler.execute();
    }
}
