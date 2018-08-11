package com.async.cloudconvert.http;

import com.async.cloudconvert.constant.HttpMethod;

import java.util.Map;

/**
 * @author Ankit Singh
 */
public final class HttpHandler {
    private HttpMethod httpMethod;
    private Builder builder;

    private HttpHandler(Builder builder, HttpMethod httpMethod) {
        this.builder = builder;
        this.httpMethod = httpMethod;
    }

    public void execute() {
            Http http=httpMethod.execute(builder);
            http.request();
    }

    public static class Builder {
        private String uri;
        private Map<String, String> headers;
        private String body;

        public Builder(String uri) {
            this.uri = uri;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public String getUri() {
            return uri;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public String getBody() {
            return body;
        }

        public HttpHandler buildWithDefaultMethod() {
            return new HttpHandler(this,HttpMethod.GET);
        }

        public HttpHandler build(HttpMethod httpMethod) {
            return new HttpHandler(this,httpMethod);
        }


    }
}
