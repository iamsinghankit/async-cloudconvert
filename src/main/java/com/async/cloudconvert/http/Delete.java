package com.async.cloudconvert.http;

import com.async.cloudconvert.http.internal.AbstractHttp;
import org.asynchttpclient.BoundRequestBuilder;

/**
 * @author Ankit Singh
 */
 class Delete<T extends CharSequence> implements Http<String> {
    private T t;
    private AbstractHttp abstractHttp;

     Delete(T t) {
        this.t = t;
        abstractHttp=AbstractHttp.get();
    }

    @Override
    public String request() {
        BoundRequestBuilder boundRequestBuilder=abstractHttp.prepareDelete((String)t);
        AbstractHttp.get().executeRequest(boundRequestBuilder.build());
        return "Success";
    }
}
