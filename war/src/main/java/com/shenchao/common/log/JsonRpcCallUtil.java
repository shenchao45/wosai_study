package com.shenchao.common.log;

import com.shenchao.common.util.MapUtil;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by shenchao on 17/12/13.
 */
public class JsonRpcCallUtil {
    /**
     * 请求头 - 请求ID，由第一层发起调用的系统赋值.
     */
    public static final String CALL_HEADER_KEY_CALL_ID = "callId";
    /**
     * 请求头 - 调用系统，由上一层发起调用的系统赋值.
     */
    public static final String CALL_HEADER_KEY_CALLER_PROJECT = "callerProject";
    /**
     * 请求头 - 用户ID，由上一层发起调用的系统赋值.
     */
    public static final String CALL_HEADER_KEY_USER_ID = "userId";
    /**
     * 请求头 - 用户名称，由上一层发起调用的系统赋值.
     */
    public static final String CALL_HEADER_KEY_USER_NAME = "userName";
    /**
     * 请求头 - 调用路径，由调用请求经过的每层系统名称拼接.
     */
    public static final String CALL_HEADER_KEY_CALL_PATH = "callPath";

    private static final Random random = new Random();

    /**
     * 生成请求ID.
     *
     * @return
     */
    public static final String generateCallId() {
        return System.currentTimeMillis() + String.format("%05d", random.nextInt(99999));
    }


    /**
     * 构建请求头Map.
     * 当callId为空则会自动生成一个.
     *
     * @param callId        请求头 - 请求ID，由第一层发起调用的系统赋值
     * @param callerProject 请求头 - 调用系统，由上一层发起调用的系统赋值
     * @param userId        请求头 - 用户ID，由上一层发起调用的系统赋值
     * @param userName      请求头 - 用户名称，由上一层发起调用的系统赋值
     * @param upperCallPath 请求头 - 由上一层发起调用的系统赋值再拼接上当前调用系统
     * @return
     */
    public static Map<String, String> buildCallHeaderMap(String callId, String callerProject, String userId, String userName, String upperCallPath) {
        Map<String, String> header = new HashMap<String, String>();
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_CALL_ID, StringUtils.isEmpty(callId) ? generateCallId() : callId);
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_CALLER_PROJECT, callerProject);
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_USER_ID, userId);
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_USER_NAME, userName);
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_CALL_PATH, buildCallPath(upperCallPath, callerProject));
        return header;
    }

    /**
     * 构建调用路径.
     *
     * @param upperCallPath 上层调用路径
     * @param callerProject 当前发起请求的调用系统
     * @return
     */
    public static String buildCallPath(String upperCallPath, String callerProject) {
        return (StringUtils.isEmpty(upperCallPath) ? "" : upperCallPath + " -> ") + callerProject;
    }


    /**
     * 构建请求头Map.
     *
     * @param callerProject 请求头 - 调用系统，由上一层发起调用的系统赋值
     * @param userId        请求头 - 用户ID，由上一层发起调用的系统赋值
     * @param userName      请求头 - 用户名称，由上一层发起调用的系统赋值
     * @return
     */
    public static Map<String, String> buildCallHeaderMap(String callerProject, String userId, String userName) {
        return buildCallHeaderMap(null, callerProject, userId, userName, null);
    }
    /**
     * 从request中获取调用头中相关信息的Map.
     *
     * @param request
     * @return
     */
    public static Map<String, String> getCallHeaderMapFromRequest(HttpServletRequest request) {
        if (request == null) {
            return new HashMap<String, String>();
        }
        Map<String, String> header = new HashMap<String, String>();
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_CALL_ID, request.getHeader(CALL_HEADER_KEY_CALL_ID));
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_CALLER_PROJECT, request.getHeader(CALL_HEADER_KEY_CALLER_PROJECT));
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_USER_ID, request.getHeader(CALL_HEADER_KEY_USER_ID));
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_USER_NAME, request.getHeader(CALL_HEADER_KEY_USER_NAME));
        MapUtil.putIfNotNull(header, CALL_HEADER_KEY_CALL_PATH, request.getHeader(CALL_HEADER_KEY_CALL_PATH));
        return header;
    }

}
