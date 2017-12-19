package com.shenchao.common.log;

import com.shenchao.exception.RuntimeBaseException;
import com.shenchao.exception.RuntimeWithCodeException;
import com.shenchao.exception.RuntimeWithStringCodeException;

/**
 * 用于异常日志
 * Created by shenchao on 17/12/14.
 */
public class ThrowableLog {
    private String project;
    private int projectCode;
    private String code;
    private String message;
    private StackTraceElement[] stackTrace;

    public ThrowableLog(Throwable throwable) {
        this(throwable, -1);
    }
    public ThrowableLog(Throwable throwable, int keepStackTraceLength) {
        if (throwable == null) {
            return;
        }
        this.message = throwable.getMessage();
        if (throwable instanceof RuntimeBaseException) {
            RuntimeBaseException baseException = (RuntimeBaseException) throwable;
            this.project = baseException.getProject();
            this.projectCode = baseException.getProjectCode();
            if (throwable instanceof RuntimeWithCodeException) {
                this.code = Integer.toString(((RuntimeWithCodeException) throwable).getCode());
            } else if (throwable instanceof RuntimeWithStringCodeException) {
                this.code = ((RuntimeWithStringCodeException)throwable).getCode();
            }
        }
        // 只保留异常堆栈的最上面keepStackTraceLength层
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        if (keepStackTraceLength < 0) {
            this.stackTrace = stackTrace;
        } else {
            if (stackTrace.length > keepStackTraceLength) {
                this.stackTrace = new StackTraceElement[keepStackTraceLength];
            } else {
                this.stackTrace = new StackTraceElement[stackTrace.length];
            }
            for (int i = 0; i < this.stackTrace.length; i++) {
                this.stackTrace[i] = stackTrace[i];
            }
        }

    }

}
