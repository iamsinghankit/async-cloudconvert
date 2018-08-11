package com.async.cloudconvert.http;


import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.Response;

/**
 * @author Ankit Singh
 */
public class DefaultAsyncHandler extends AsyncCompletionHandler{


    @Override
    public void onThrowable(Throwable t) {
        System.out.println(t.getMessage());
        t.printStackTrace();
    }

    @Override
    public Object onCompleted(Response response) throws Exception {
        System.out.println(response.getResponseBody());
        return response;
    }
}
