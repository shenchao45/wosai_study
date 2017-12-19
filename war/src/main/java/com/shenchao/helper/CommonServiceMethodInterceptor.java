package com.shenchao.helper;

import com.shenchao.common.log.JsonRpcCallUtil;
import com.shenchao.common.log.MethodEndLog;
import com.shenchao.common.log.MethodStartLog;
import com.shenchao.util.SpringWebUtil;
import net.logstash.logback.marker.Markers;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shenchao on 17/12/12.
 */
public class CommonServiceMethodInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceMethodInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long before = System.currentTimeMillis();
        MethodStartLog startLog = new MethodStartLog(invocation.getMethod(), invocation.getArguments(), JsonRpcCallUtil.getCallHeaderMapFromRequest(SpringWebUtil.getCurrentRequest()));
        MethodEndLog endLog = new MethodEndLog(startLog);
        LOGGER.trace(Markers.appendFields(startLog), "invoking service method start");
        return null;
    }
}
