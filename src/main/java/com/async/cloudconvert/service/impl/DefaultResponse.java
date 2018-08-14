package com.async.cloudconvert.service.impl;

import com.async.cloudconvert.exception.RuntimeExceptionWrapper;
import com.async.cloudconvert.service.CloudResponse;
import com.async.cloudconvert.util.JsonUtil;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;

import java.util.Map;

/**
 * @author Ankit Singh
 */
public class DefaultResponse implements CloudResponse<Response> {
    private ListenableFuture<Response> response;

    public DefaultResponse(ListenableFuture<Response> response) {
        this.response = response;
    }

    @Override
    public Map getAsMap() {
        return toObject(Map.class);
    }

    @Override
    public String getAsString() {
        return getResponse();
    }

    @Override
    public <T> T getAs(Class<T> clazz) {
        return toObject(clazz);
    }

    private <T> T toObject(Class<T> clazz) {
        return JsonUtil.toReference(getResponse(), clazz);
    }

    private String getResponse() {
       return RuntimeExceptionWrapper.wrap(() -> response.get().getResponseBody());
    }
}
