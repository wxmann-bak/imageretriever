package com.jimtang.imagesav;

/**
 * Created by tangz on 3/30/2015.
 */
public class ImageRetrievalException extends RuntimeException {
    public ImageRetrievalException() {
        super();
    }

    public ImageRetrievalException(String message) {
        super(message);
    }

    public ImageRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImageRetrievalException(Throwable cause) {
        super(cause);
    }

    protected ImageRetrievalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
