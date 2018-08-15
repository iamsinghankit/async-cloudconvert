package com.async.cloudconvert.request;

import com.async.cloudconvert.constant.ProcessMode;

import static com.async.cloudconvert.util.ObjectUtil.requireNonEmpty;

/**
 * @author Ankit Singh
 */
public class Header  {
    public  static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer";
    public  static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String MODE="mode";
    public static final String SECURE_URL="https:";
    private final String apiKey;
    private final String contentType;
    private final ProcessMode processMode;


    public Header(String apiKey,ProcessMode processMode) {

        this(apiKey,processMode, DEFAULT_CONTENT_TYPE);
    }

    public Header(String apiKey,ProcessMode processMode, String contentType) {
        requireNonEmpty(apiKey, "Invalid API_KEY");
        this.apiKey = new String( BEARER + " " + apiKey);
        this.contentType =  contentType;
        this.processMode=processMode;
    }


    public String getApiKey() {
        return apiKey;
    }

    public String getContentType() {
        return contentType;
    }

    public ProcessMode getProcessMode(){
        return processMode;
    }
}
