package com.async.cloudconvert.http.internal;

import com.async.cloudconvert.constant.HttpMethod;
import com.async.cloudconvert.http.DefaultAsyncHandler;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Request;

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
        return HttpHelper.prepare(HttpMethod.POST.getMethod(), url);
    }

    public BoundRequestBuilder prepareDelete(String url) {
        return HttpHelper.prepare(HttpMethod.POST.getMethod(), url);
    }

    public void executeRequest(Request request) {
        HttpHelper.execute(request, new DefaultAsyncHandler());
    }

    public void executeRequest(Request request, AsyncCompletionHandler asyncCompletionHandler) {
        HttpHelper.execute(request, asyncCompletionHandler);
    }

    private static class HttpHelper {
        private static final AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();


        private static BoundRequestBuilder prepare(String method, String url) {
            return asyncHttpClient.prepare(method, url);
        }

        private static void execute(Request request, AsyncCompletionHandler asyncCompletionHandler) {
            asyncHttpClient.executeRequest(request, asyncCompletionHandler);
        }
    }
}
