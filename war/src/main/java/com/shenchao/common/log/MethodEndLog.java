package com.shenchao.common.log;

import java.lang.reflect.Method;

/**
 * Created by shenchao on 17/12/14.
 */
public class MethodEndLog extends MethodStartLog {
    /**
     * 持续时间.
     */
    private long duration;
    /**
     * 是否执行成功.
     */
    private Boolean success;
    /**
     * 异常.
     */
    private ThrowableLog exception;
    /**
     * 调用方法返回结果
     */
    private Object result;



    public MethodEndLog(Method method, Object[] arguments, long duration, Boolean success, Throwable throwable) {
        super(method, arguments);
        this.duration = duration;
        this.success = success;
        this.exception = new ThrowableLog(throwable);
    }

    public MethodEndLog(String methodName, Object[] arguments, long duration, Boolean success, Throwable throwable) {
        super(methodName, arguments);
        this.duration = duration;
        this.success = success;
        this.exception = new ThrowableLog(throwable);
    }

    public MethodEndLog(MethodStartLog startLog) {
        this.setDeclaringClass(startLog.getDeclaringClass());
        this.setMethod(startLog.getMethod());
        this.setReturnType(startLog.getReturnType());
        this.setArguments(startLog.getArguments());
        this.setHeader(startLog.getHeader());
    }

    public MethodEndLog(MethodStartLog startLog, long duration, Boolean success, Throwable throwable) {
        this(startLog);
        this.duration = duration;
        this.success = success;
        this.exception = new ThrowableLog(throwable);
    }

    public MethodEndLog(MethodStartLog startLog, long duration, Boolean success, Throwable throwable, Object result) {
        this(startLog);
        this.duration = duration;
        this.success = success;
        this.exception = new ThrowableLog(throwable);
        this.result = result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setException(ThrowableLog exception) {
        this.exception = exception;
    }
}
