package com.shenchao.exception;

public class CommonInvalidParameterException extends CommonException {
    public CommonInvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonInvalidParameterException(String message) {
        super(message);
    }

    @Override
    public int getCode() {
        return CODE_INVALID_PARAMETER;
    }
}
