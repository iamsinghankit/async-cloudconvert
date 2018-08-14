package com.async.cloudconvert.http.internal;

import com.async.cloudconvert.http.HttpMethod;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

/**
 * @author Ankit Singh
 */
public class AbstractHttp {

    private static AbstractHttp abstractHttp = new AbstractHttp();

    private AbstractHttp() {
    }

    public static AbstractHttp get() {
        return abstractHttp;
    }

    public BoundRequestBuilder preparePost(String url) {
        return HttpHelper.prepare(HttpMethod.POST.getName(), url);
    }

    public BoundRequestBuilder prepareDelete(String url) {
        return HttpHelper.prepare(HttpMethod.DELETE.getName(), url);
    }

    public void executeRequest(Request request, AsyncCompletionHandler asyncCompletionHandler) {
        HttpHelper.execute(request, asyncCompletionHandler);
    }

    public ListenableFuture<Response> executeRequest(Request request) {
        return HttpHelper.execute(request);
    }

    private static class HttpHelper {
        private static final AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();


        private static BoundRequestBuilder prepare(String method, String url) {
            return asyncHttpClient.prepare(method, url);
        }

        private static void execute(Request request, AsyncCompletionHandler asyncCompletionHandler) {
            asyncHttpClient.executeRequest(request, asyncCompletionHandler);
        }

        private static ListenableFuture<Response> execute(Request request) {
            return asyncHttpClient.executeRequest(request);
        }
    }
}
