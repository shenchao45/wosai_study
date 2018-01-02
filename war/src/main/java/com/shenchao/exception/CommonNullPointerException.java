package com.shenchao.exception;

public class CommonNullPointerException extends CommonException {
    public CommonNullPointerException(String codeDesc, Throwable ex) {
        super(codeDesc,ex);
    }
    public CommonNullPointerException(String message) {
        super(message);
    }

    @Override
    public int getCode() {
        return CODE_NULL_POINTER_EXCEPTION;
    }
}
