package com.async.cloudconvert.http;

import com.async.cloudconvert.http.internal.AbstractHttp;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

/**
 * @author Ankit Singh
 */
class Delete<T extends HttpHandler.Builder> implements Http {
    private T t;
    private AbstractHttp abstractHttp;

    Delete(T t) {
        this.t = t;
        abstractHttp = AbstractHttp.get();
    }

    @Override
    public <T> void requestAsync(T t) {
        throw new UnsupportedOperationException("There is no need for async request in DELETE call!!");
    }

    @Override
    public ListenableFuture<Response> requestSync() {
        return abstractHttp.executeRequest(request());
    }


    private Request request() {
        BoundRequestBuilder boundRequestBuilder = abstractHttp.prepareDelete(t.getUri());
        return boundRequestBuilder.build();

    }
}
