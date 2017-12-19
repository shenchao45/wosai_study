package com.shenchao.exception;

/**
 * 配置异常，需要check.
 * Created by shenchao on 17/12/14.
 */
public class CommonConfigException extends Exception {
    public CommonConfigException(String message) {
        super(message);
    }

    public CommonConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}
