package com.async.cloudconvert.http;

import com.async.cloudconvert.http.internal.AbstractHttp;
import org.asynchttpclient.BoundRequestBuilder;

/**
 * @author Ankit Singh
 */
public class Post implements Http {
    private HttpHandler.Builder builder;


    public Post(HttpHandler.Builder builder) {
        this.builder = builder;
    }

    @Override
    public void request() {
        BoundRequestBuilder request = AbstractHttp.get().preparePost(builder.getUri());
        builder.getHeaders().forEach((h, v) -> request.addHeader(h, v));
        request.setBody(builder.getBody());
        AbstractHttp.get().executeRequest(request.build());
    }
}
