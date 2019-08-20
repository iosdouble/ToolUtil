package com.nh.code.exception.code;

/**
 * @Classname ExceptionCodeGeneratorImpl
 * @Description TODO
 * @Date 2019/8/20 2:35 PM
 * @Created by nihui
 */
public class ExceptionCodeGeneratorImpl implements IExceptionCodeGenerator {
    private String projectExceptionCode = "00000";

    public ExceptionCodeGeneratorImpl() {
    }

    public void setProjectExceptionCode(String projectExceptionCode) {
        this.projectExceptionCode = projectExceptionCode;
    }

    public String getProjectExceptionCode() {
        return this.projectExceptionCode;
    }
}
