package com.async.cloudconvert.http;

/**
 * @author Ankit Singh
 */
public enum HttpMethod {
    POST("POST"){
        @Override
        public <T>Http execute(T t) {
            return new Post((HttpHandler.Builder) t);
        }
    },

    GET("GET"){
        @Override
        public <T>Http execute(T t) {
            throw new UnsupportedOperationException();
        }
    },

    DELETE("DELETE"){
        @Override
        public <T> Http execute(T t) {
            return new Delete((HttpHandler.Builder) t);
        }
    };

    private String value;
    private HttpMethod(String method){
        this.value=method;
    }

    public String getName(){
        return value;
    }

    public abstract <T> Http execute(T t);
}
