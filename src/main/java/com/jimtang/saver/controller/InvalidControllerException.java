package com.jimtang.saver.controller;

/**
 * Created by tangz on 8/29/2015.
 */
public class InvalidControllerException extends RuntimeException {
    public InvalidControllerException() {
        super();
    }

    public InvalidControllerException(String message) {
        super(message);
    }

    public InvalidControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidControllerException(Throwable cause) {
        super(cause);
    }

    protected InvalidControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
