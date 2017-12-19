package com.shenchao.exception;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by shenchao on 17/12/14.
 */
public abstract class CommonException extends RuntimeWithCodeException{

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    // 101*为请求数据异常
    public static final int CODE_INVALID_PARAMETER = 10101;
    public static final int CODE_CANNOT_SET_INCORRECT_VALUE = 10102;
    public static final int CODE_DATA_VERSION_MISMATCH = 10103;
    public static final int CODE_DATABASE_DUPLICATE_KEY = 10104;
    public static final int CODE_UNKNOWN_COLUMN = 10105;

    public static final int CODE_ACCESS_DENIED = 10106;

    // 102*为数据库异常
    public static final int CODE_DATA_ACCESS_EXCEPTION = 10201;
    public static final int CODE_CANNOT_GET_JDBC_CONNECTION = 10202;
    public static final int CODE_DATA_OBJECT_NOT_EXISTS = 10203;

    // 103*为IO或网络连接异常
    public static final int CODE_IO_EXCEPTION = 10301;
    public static final int CODE_NET_CONNECT_ERROR = 10302;
    public static final int CODE_UNKNOWN_HOST_EXCEPTION = 10303;

    // 104*为未知异常
    public static final int CODE_UNKNOWN_ERROR = 10401;
    public static final int CODE_NULL_POINTER_EXCEPTION = 10402;

    // 业务异常
    public static final int CODE_BIZ_EXCEPTION = 20100;

    public static final Map<Integer, String> COMMON_CODES_DESC_MAP = new LinkedHashMap<Integer, String>() {{
        put(CODE_INVALID_PARAMETER, "参数不合法");
        put(CODE_CANNOT_SET_INCORRECT_VALUE, "字段被赋错误的值");
        put(CODE_DATA_VERSION_MISMATCH, "对象版本不正确或数据对象不存在");
        put(CODE_DATABASE_DUPLICATE_KEY, "主键或索引不唯一");
        put(CODE_UNKNOWN_COLUMN, "未知属性");

        put(CODE_ACCESS_DENIED, "访问拒绝");

        put(CODE_DATA_ACCESS_EXCEPTION, "数据访问异常"); // spring data(database, redis...)
        put(CODE_CANNOT_GET_JDBC_CONNECTION, "获取不到数据库链接");
        put(CODE_DATA_OBJECT_NOT_EXISTS, "数据对象不存在");

        put(CODE_IO_EXCEPTION, "IO异常");
        put(CODE_NET_CONNECT_ERROR, "网络链接异常");
        put(CODE_UNKNOWN_HOST_EXCEPTION, "未知域名");

        put(CODE_UNKNOWN_ERROR, "未知异常");
        put(CODE_NULL_POINTER_EXCEPTION, "空指针异常");

        put(CODE_BIZ_EXCEPTION, "业务异常");
    }};

    /**
     * 获取异常码对应描述.
     *
     * @param code
     * @return
     */
    public static String getCodeDesc(int code) {
        return COMMON_CODES_DESC_MAP.get(code);
    }




}
