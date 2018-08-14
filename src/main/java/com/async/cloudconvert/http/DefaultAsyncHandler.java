package com.async.cloudconvert.http;


import com.async.cloudconvert.service.Mapper;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.Response;

import java.util.function.Function;

/**
 * @author Ankit Singh
 */
public class DefaultAsyncHandler<T extends Function> extends AsyncCompletionHandler {

    private Mapper t;

    public DefaultAsyncHandler(Mapper t) {
        this.t = t;
    }


    @Override
    public void onThrowable(Throwable t) {
        throw new RuntimeException(t);
    }

    @Override
    public Object onCompleted(Response response) throws Exception {
       t.set(response);
        System.out.println("response..."+response.getResponseBody());
       return response;
//        AbstractHttp.get().prepareDelete("https:"+map.get("url"));
    }



}
