package com.shenchao.helper;
/**
 * 通用异常Json格式(借用JsonRpc的异常格式).
 * 直接使用ErrorResolver.JsonError得到的bean使用Jackson序列化有异常，可能是因为其属性的无get方法的原因.
 */
public class CommonJsonError {
    private int code;
    private String message;
    private Object data;
    public CommonJsonError(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
