package com.async.cloudconvert.request;

import static com.async.cloudconvert.util.ObjectUtil.requireNonEmpty;

/**
 * @author Ankit Singh
 */
public class Header  {
    public  static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer";
    public  static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String SECURE_URL="https:";
    private final String apiKey;
    private final String contentType;


    public Header(String apiKey) {
        this(apiKey, DEFAULT_CONTENT_TYPE);
    }

    public Header(String apiKey, String contentType) {
        requireNonEmpty(apiKey, "Invalid API_KEY");
        this.apiKey = new String( BEARER + " " + apiKey);
        this.contentType =  contentType;
    }


    public String getApiKey() {
        return apiKey;
    }

    public String getContentType() {
        return contentType;
    }
}
