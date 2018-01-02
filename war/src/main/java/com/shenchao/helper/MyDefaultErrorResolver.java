package com.shenchao.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonrpc4j.DefaultErrorResolver;
import com.shenchao.constant.ProjectConstant;
import com.shenchao.exception.CommonException;
import com.shenchao.exception.RuntimeWithCodeException;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 自定义DefaultErrorResolver处理，JsonRpc结果返回时使用，增加异常码以及MyErrorData输出异常发生的系统及系统编码，构造方法中设置当前系统.
 *
 */
public class MyDefaultErrorResolver extends DefaultErrorResolver {
    // 设置当前系统
    public MyDefaultErrorResolver() {
        CommonException.resetCurrentProject(ProjectConstant.UNKNOWN_CODE);
    }

    @Override
    public JsonError resolveError(Throwable t, Method method,
                                  List<JsonNode> arguments) {
        if (t instanceof RuntimeWithCodeException) {
            RuntimeWithCodeException exception = (RuntimeWithCodeException) t;
            return new JsonError(exception.getCode(), t.getMessage(),
                    new MyErrorData(t.getClass().getName(), t.getMessage(), exception.getProject(), exception.getProjectCode()));
        } else {
            return super.resolveError(t, method, arguments);
        }
    }
}
