package com.shenchao.exception;

public class CommonUnknownException extends CommonException {
    public CommonUnknownException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonUnknownException(String message) {
        super(message);
    }
    @Override
    public int getCode() {
        return CODE_UNKNOWN_ERROR;
    }
}
