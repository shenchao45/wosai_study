package com.shenchao.exception;

import com.shenchao.constant.ProjectConstant;

/**
 * Created by shenchao on 17/12/14.
 */
public abstract class RuntimeBaseException extends RuntimeException {
    public RuntimeBaseException(String message) {
        super(message);
    }

    public RuntimeBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeBaseException(Throwable cause) {
        super(cause);
    }

    /**
     * 当前系统编码.
     */
    private static int CURRENT_PROJECT_CODE = ProjectConstant.UNKNOWN_CODE;
    /**
     * 当前系统.
     */
    private static String CURRENT_PROJECT = ProjectConstant.UNKNOWN;

    private String project;

    private Integer projectCode;

    /**
     * 重新设置发生异常的系统.
     *
     * @param projectCode
     */
    public static void resetCurrentProject(int projectCode) {
        CURRENT_PROJECT_CODE = projectCode;
        CURRENT_PROJECT = ProjectConstant.NAMES_MAP.get(projectCode);
    }

    public void setProject(String project) {
        this.project = project;
    }

    /**
     * 发生异常的系统.
     *
     * @return
     */
    public String getProject() {
        return this.project == null ? CURRENT_PROJECT : this.project;
    }

    /**
     * 发生异常的系统编码.
     *
     * @return
     */
    public int getProjectCode() {
        return this.projectCode == null ? CURRENT_PROJECT_CODE : this.projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

}
