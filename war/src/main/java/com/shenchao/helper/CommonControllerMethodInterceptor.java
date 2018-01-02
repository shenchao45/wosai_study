package com.shenchao.helper;

import com.shenchao.common.log.JsonRpcCallUtil;
import com.shenchao.common.log.MethodEndLog;
import com.shenchao.common.log.MethodStartLog;
import com.shenchao.exception.CommonException;
import com.shenchao.exception.RuntimeWithCodeException;
import com.shenchao.util.CollectionUtil;
import com.shenchao.util.SpringContextHolder;
import com.shenchao.util.SpringWebUtil;
import net.logstash.logback.marker.Markers;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shenchao on 17/12/13.
 */
public class CommonControllerMethodInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonControllerMethodInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        CommonServiceMethodInterceptor serviceMethodInterceptor = SpringContextHolder.getBean(CommonServiceMethodInterceptor.class);
        long before = System.currentTimeMillis();
        MethodStartLog startLog = new MethodStartLog(invocation.getMethod(), processArguments(invocation.getArguments()).toArray(), JsonRpcCallUtil.getCallHeaderMapFromRequest(SpringWebUtil.getCurrentRequest()));
        LOGGER.trace(Markers.appendFields(startLog), "invoking controller method start");
        boolean success = false;

        Throwable tex = null;
        Map<String, Object> rsMap = CollectionUtil.hashMap("id", 0);
        Object result = null;
        try {
            result = invocation.proceed();
            success = true;
            rsMap.put("result", result);
        } catch (Throwable ex) {
            success = false;
            tex = serviceMethodInterceptor.processException(ex);
            rsMap.put("error", processException(tex, serviceMethodInterceptor));
        } finally {
            long duration = System.currentTimeMillis() - before;
            LOGGER.trace(Markers.appendFields(new MethodEndLog(startLog, duration, success, tex)), "invoking controller method end");
        }
        return result;
    }

    private List<Object> processArguments(Object[] arguments) {
        List<Object> argumentList = new ArrayList<Object>();
        for (Object argument : arguments) {
            if (argument instanceof MultipartFile) {
                argumentList.add("[org.springframework.web.multipart.MultipartFile]");
            } else if (argument instanceof ServletRequest) {
                argumentList.add("[javax.servlet.ServletRequest]");
            } else if (argument instanceof ServletResponse) {
                argumentList.add("[javax.servlet.ServletResponse]");
            } else {
                argumentList.add(argument);
            }
        }
        return argumentList;
    }


    /**
     * 处理异常-借用JsonRPC异常格式.
     */
    private Object processException(Throwable tex, CommonServiceMethodInterceptor serviceMethodInterceptor) {
        if (tex instanceof RuntimeWithCodeException) {
            RuntimeWithCodeException exception = (RuntimeWithCodeException) tex;
            return new CommonJsonError(exception.getCode(), tex.getMessage(),
                    new MyErrorData(tex.getClass().getName(), tex.getMessage(), exception.getProject(), exception.getProjectCode()));
        }
        return new CommonJsonError(CommonException.CODE_UNKNOWN_ERROR, CommonException.getCodeDesc(CommonException.CODE_UNKNOWN_ERROR), null);
    }

}
