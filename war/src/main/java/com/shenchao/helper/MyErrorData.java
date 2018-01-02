package com.shenchao.helper;

import com.googlecode.jsonrpc4j.DefaultErrorResolver;

public class MyErrorData extends DefaultErrorResolver.ErrorData{
    /**
     * 发生异常的系统.
     */
    private String project;

    /**
     * 发生异常的系统编码.
     */
    private int projectCode;
    public MyErrorData(String exceptionTypeName, String message, String project, int projectCode) {
        super(exceptionTypeName, message);
        this.project = project;
        this.projectCode = projectCode;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }
}
