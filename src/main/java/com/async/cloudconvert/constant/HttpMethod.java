package com.async.cloudconvert.constant;

import com.async.cloudconvert.http.Http;
import com.async.cloudconvert.http.HttpHandler;
import com.async.cloudconvert.http.Post;

/**
 * @author Ankit Singh
 */
public enum HttpMethod {
    POST("POST"){
        @Override
        public Http execute(HttpHandler.Builder builder) {
            return new Post(builder);
        }
    },

    GET("GET"){
        @Override
        public Http execute(HttpHandler.Builder builder) {
            throw new UnsupportedOperationException();
        }
    },

    DELETE("DELETE"){
        @Override
        public Http execute(HttpHandler.Builder builder) {
            throw new UnsupportedOperationException();
        }
    };

    private String value;
    private HttpMethod(String method){
        this.value=method;
    }

    public String getMethod(){
        return value;
    }

    public abstract  Http execute(HttpHandler.Builder builder);
}
