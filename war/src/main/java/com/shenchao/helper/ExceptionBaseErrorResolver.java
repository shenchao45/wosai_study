package com.shenchao.helper;

import com.shenchao.constant.ProjectConstant;
import com.shenchao.exception.CommonConfigException;
import com.shenchao.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionBaseErrorResolver extends MyDefaultErrorResolver {
    private Logger logger = LoggerFactory.getLogger(ExceptionBaseErrorResolver.class);

    public ExceptionBaseErrorResolver() {
        // TODO 说明
        try {
            int currentProjectCode = -1;
            ProjectConstant.addProject("finance-backend", currentProjectCode);
            // 设置异常发生系统
            CommonException.resetCurrentProject(currentProjectCode);
        } catch (CommonConfigException e) {
            logger.error("ExceptionBaseErrorResolver config currentProject error", e);
        }
    }
}
