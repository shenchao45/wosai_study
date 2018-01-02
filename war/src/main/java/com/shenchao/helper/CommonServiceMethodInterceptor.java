package com.shenchao.helper;

import com.shenchao.common.log.JsonRpcCallUtil;
import com.shenchao.common.log.MethodEndLog;
import com.shenchao.common.log.MethodStartLog;
import com.shenchao.common.log.ThrowableLog;
import com.shenchao.exception.CommonException;
import com.shenchao.exception.CommonInvalidParameterException;
import com.shenchao.exception.CommonNullPointerException;
import com.shenchao.exception.CommonUnknownException;
import com.shenchao.util.SpringWebUtil;
import net.logstash.logback.marker.Markers;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.UncategorizedSQLException;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.ConnectException;
import java.net.UnknownHostException;

/**
 * Created by shenchao on 17/12/12.
 */
public class CommonServiceMethodInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceMethodInterceptor.class);
    private boolean commonExceptionDeepCause = false;
    private boolean logNotFindMethodsResult = false;

    public boolean isCommonExceptionDeepCause() {
        return commonExceptionDeepCause;
    }

    public void setCommonExceptionDeepCause(boolean commonExceptionDeepCause) {
        this.commonExceptionDeepCause = commonExceptionDeepCause;
    }

    public boolean isLogNotFindMethodsResult() {
        return logNotFindMethodsResult;
    }

    public void setLogNotFindMethodsResult(boolean logNotFindMethodsResult) {
        this.logNotFindMethodsResult = logNotFindMethodsResult;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long before = System.currentTimeMillis();
        MethodStartLog startLog = new MethodStartLog(invocation.getMethod(), invocation.getArguments(), JsonRpcCallUtil.getCallHeaderMapFromRequest(SpringWebUtil.getCurrentRequest()));
        MethodEndLog endLog = new MethodEndLog(startLog);
        LOGGER.trace(Markers.appendFields(startLog), "invoking service method start");
        boolean success = false;

        Throwable tex = null;
        try {
            Object result = invocation.proceed();
            success = true;
            if (logNotFindMethodsResult && !invocation.getMethod().getName().startsWith("find")) {
                endLog.setResult(result);
            }
            return result;
        } catch (Throwable ex) {
            success = false;
            tex = processException(ex);
            throw tex;
        } finally {
            long duration = System.currentTimeMillis() - before;
            endLog.setDuration(duration);
            endLog.setSuccess(success);
            endLog.setException(new ThrowableLog(tex));
            LOGGER.trace(Markers.appendFields(endLog), "invoking service method end");
        }
    }

    private Throwable getActException(Throwable ex) {
        if (ex instanceof UndeclaredThrowableException) {
            ex = ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
            return getActException(ex);
        } else if (ex instanceof ArithmeticException) {
            ex = ex.getCause();
        } else if (commonExceptionDeepCause && ex.getCause() instanceof CommonException) {
            ex = ex.getCause();
        }
        return ex;
    }

    public Throwable processException(Throwable ex) {
        ex = getActException(ex);

        Throwable tex;
        if (ex instanceof MethodConstraintViolationException) {
            StringBuilder sb = new StringBuilder();
            for (MethodConstraintViolation<?> violation : ((MethodConstraintViolationException) ex).getConstraintViolations()) {
                if (sb.length() > 0)
                    sb.append(";");
                sb.append(violation.getMessage());
            }
            tex = new CommonInvalidParameterException(sb.toString(), ex);
        }
        if (ex instanceof NullPointerException) {
            tex = new CommonNullPointerException(CommonException.getCodeDesc(CommonException.CODE_NULL_POINTER_EXCEPTION), ex);
        } else if (ex instanceof CommonException) {
            tex = ex;
        } else {
            tex = new CommonUnknownException(CommonException.getCodeDesc(CommonException.CODE_UNKNOWN_ERROR), ex);
        }
        return tex;
    }
}
