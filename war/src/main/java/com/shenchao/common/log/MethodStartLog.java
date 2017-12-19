package com.shenchao.common.log;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 用来记录方法的日志
 * Created by shenchao on 17/12/13.
 */
public class MethodStartLog {
    private Class declaringClass;
    private String method;
    private Class returnType;
    private Object[] arguments;
    private Map<String, String> header;

    public Class getReturnType() {
        return returnType;
    }

    public void setReturnType(Class returnType) {
        this.returnType = returnType;
    }

    public MethodStartLog() {
    }

    public MethodStartLog(Method method, Object[] arguments, Map<String, String> header) {
        this.method = method.getClass().getName();
        this.arguments = arguments;
        this.header = header;
    }

    public MethodStartLog(Method method, Object[] arguments) {
        this(method, arguments, null);
    }


    public MethodStartLog(String method, Object[] arguments) {
        this.method = method;
        this.arguments = arguments;
    }

    public Class getDeclaringClass() {
        return declaringClass;
    }

    public void setDeclaringClass(Class declaringClass) {
        this.declaringClass = declaringClass;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
}
