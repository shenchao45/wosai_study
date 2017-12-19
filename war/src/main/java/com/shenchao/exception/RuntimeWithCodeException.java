package com.shenchao.exception;

/**
 * Created by shenchao on 17/12/14.
 */
public abstract class RuntimeWithCodeException extends RuntimeBaseException{
    public RuntimeWithCodeException(String message) {
        super(message);
    }

    public RuntimeWithCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeWithCodeException(Throwable cause) {
        super(cause);
    }

    public abstract int getCode();
}
