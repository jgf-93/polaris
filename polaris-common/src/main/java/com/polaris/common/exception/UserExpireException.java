package com.polaris.common.exception;

public class UserExpireException extends RuntimeException {
    public UserExpireException() {
    }

    public UserExpireException(String message) {
        super(message);
    }

    public UserExpireException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExpireException(Throwable cause) {
        super(cause);
    }

    public UserExpireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
