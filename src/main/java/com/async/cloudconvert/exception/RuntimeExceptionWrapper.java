package com.async.cloudconvert.exception;

/**
 * @author Ankit Singh
 */
@FunctionalInterface
public interface RuntimeExceptionWrapper<T> {
    T execute() throws Exception;

    static <T> T wrap(RuntimeExceptionWrapper<T> wrapper){
        try {
            return wrapper.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
