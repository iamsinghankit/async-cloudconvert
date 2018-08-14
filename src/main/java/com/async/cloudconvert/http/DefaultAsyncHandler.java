package com.async.cloudconvert.http;


import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.Response;

/**
 * @author Ankit Singh
 */
public abstract class DefaultAsyncHandler extends AsyncCompletionHandler {


    @Override
    public void onThrowable(Throwable t) {
        throw new RuntimeException(t);
    }

    @Override
    public abstract Object onCompleted(Response response);


}
