package com.async.cloudconvert.http;

/**
 * @author Ankit Singh
 */
public class Delete implements Http {
    private HttpHandler.Builder httpHandlerBuilder;

    public Delete(HttpHandler.Builder httpHandlerBuilder) {
        this.httpHandlerBuilder = httpHandlerBuilder;
    }

    @Override
    public void request() {

    }
}
