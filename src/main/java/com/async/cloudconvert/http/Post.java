package com.async.cloudconvert.http;

import com.async.cloudconvert.http.internal.AbstractHttp;
import com.async.cloudconvert.service.Mapper;
import com.async.cloudconvert.service.impl.ResponseMapper;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.Request;

/**
 * @author Ankit Singh
 */
class Post<T extends HttpHandler.Builder> implements Http<Mapper> {
    private T builder;
    private Mapper mapper;
    private AbstractHttp abstractHttp;


    Post(T builder) {
        this(builder, new ResponseMapper());
    }

    Post(T builder, Mapper mapper) {
        this.builder = builder;
        this.mapper = mapper;
        this.abstractHttp = AbstractHttp.get();
    }

    @Override
    public Mapper request() {
        BoundRequestBuilder request = abstractHttp.preparePost(builder.getUri());
        headers(request);
        body(request);
        execute(request.build(),new DefaultAsyncHandler(mapper));
        return mapper;
    }

    private void headers(BoundRequestBuilder request) {
        builder.getHeaders().forEach((h, v) -> request.addHeader(h, v));
    }

    private void body(BoundRequestBuilder request) {
        request.setBody(builder.getBody());
    }

    private void execute(Request request,AsyncCompletionHandler asyncCompletionHandler) {
        abstractHttp.executeRequest(request, asyncCompletionHandler);
    }
}
