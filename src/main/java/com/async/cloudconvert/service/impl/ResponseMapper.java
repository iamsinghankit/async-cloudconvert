package com.async.cloudconvert.service.impl;

import com.async.cloudconvert.service.Mapper;
import com.async.cloudconvert.util.JsonUtil;
import org.asynchttpclient.Response;

import java.util.Map;

/**
 * @author Ankit Singh
 */
public class ResponseMapper implements Mapper<Response> {
    Response response;

    @Override
    public void set(Response t) {
        this.response = t;
    }

    @Override
    public Map getAsMap() {
        return JsonUtil.toReference(response.getResponseBody(), Map.class);
    }
}
