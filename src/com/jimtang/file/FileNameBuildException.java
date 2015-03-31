package com.jimtang.file;

/**
 * Created by tangz on 3/30/2015.
 */
public class FileNameBuildException extends RuntimeException {
    public FileNameBuildException() {
        super();
    }

    public FileNameBuildException(String message) {
        super(message);
    }

    public FileNameBuildException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNameBuildException(Throwable cause) {
        super(cause);
    }

    protected FileNameBuildException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
