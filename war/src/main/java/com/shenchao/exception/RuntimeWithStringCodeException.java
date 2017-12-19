package com.shenchao.exception;

/**
 * 异常码是String型的异常基类
 * Created by shenchao on 17/12/14.
 */
public abstract class RuntimeWithStringCodeException extends RuntimeBaseException {

    public RuntimeWithStringCodeException(String message) {
        super(message);
    }

    public RuntimeWithStringCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeWithStringCodeException(Throwable cause) {
        super(cause);
    }

    public abstract String getCode();
}
