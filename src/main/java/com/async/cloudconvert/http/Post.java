package com.async.cloudconvert.http;

import com.async.cloudconvert.http.internal.AbstractHttp;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

/**
 * @author Ankit Singh
 */
class Post<T extends HttpHandler.Builder> implements Http {
    private T builder;
    private AbstractHttp abstractHttp;


    Post(T builder) {
        this.builder = builder;
        this.abstractHttp = AbstractHttp.get();
    }

    @Override
    public <T> void requestAsync(T t) {
        abstractHttp.executeRequest(request(), (AsyncCompletionHandler) t);
    }

    @Override
    public ListenableFuture<Response> requestSync() {
        return abstractHttp.executeRequest(request());
    }

    private Request request() {
        BoundRequestBuilder request = abstractHttp.preparePost(builder.getUri());
        headers(request);
        body(request);
        return request.build();
    }

    private void headers(BoundRequestBuilder request) {
        builder.getHeaders().forEach((h, v) -> request.addHeader(h, v));
    }

    private void body(BoundRequestBuilder request) {
        request.setBody(builder.getBody());
    }


}
