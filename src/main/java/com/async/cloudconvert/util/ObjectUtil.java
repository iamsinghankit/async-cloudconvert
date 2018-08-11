package com.async.cloudconvert.util;

/**
 * @author Ankit Singh
 */
public final class ObjectUtil {
    private ObjectUtil(){
            throw new AssertionError("No com.async.cloudconvert.util.ObjectUtil instances for you!");
    }

    public static void requireNonEmpty(CharSequence value,String message){
        if(value==null||value.length()==0)
            throw new IllegalArgumentException(message);

    }
}
