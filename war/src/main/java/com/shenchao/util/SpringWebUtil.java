package com.shenchao.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shenchao on 17/12/13.
 */
public class SpringWebUtil {

    /**
     * 从Spring web中获取当前request对象
     */
    public static HttpServletRequest getCurrentRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null && requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        return null;
    }

    /**
     * 从Spring web中获取当前response对象
     */
    public static HttpServletResponse getCurrentResponse(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null && requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes)requestAttributes).getResponse();
        }
        return null;
    }
}
