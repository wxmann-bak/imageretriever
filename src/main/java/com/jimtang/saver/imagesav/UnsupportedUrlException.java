package com.jimtang.saver.imagesav;

/**
 * Created by tangz on 4/1/2015.
 */
public class UnsupportedUrlException extends RuntimeException {
    public UnsupportedUrlException() {
        super();
    }

    public UnsupportedUrlException(String message) {
        super(message);
    }

    public UnsupportedUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedUrlException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
