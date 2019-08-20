package com.nh.code.exception;

import com.nh.code.exception.bean.ExceptionMsg;
import com.nh.code.util.json.JsonUtil;

/**
 * @Classname ParentRuntimeException
 * @Description TODO
 * @Date 2019/8/20 2:41 PM
 * @Created by nihui
 */
public class ParentRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 713616801491210431L;
    private ExceptionMsg exceptionMsg = new ExceptionMsg();

    public ParentRuntimeException(ExceptionMsg exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public ParentRuntimeException(String errorCode, String errorMsg) {
        this.exceptionMsg.setErrorCode(errorCode);
        this.exceptionMsg.setErrorMsg(errorMsg);
    }

    public ExceptionMsg getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setErrorId(String errorId) {
        this.exceptionMsg.setErrorId(errorId);
    }

    public void setErrorCode(String projectErrorCode) {
        String errorCode = this.exceptionMsg.getErrorCode();
        errorCode = projectErrorCode + "-" + errorCode;
        this.exceptionMsg.setErrorCode(errorCode);
    }

    private String toJson() {
        String responseStr = JsonUtil.toJson(this.exceptionMsg);
        return responseStr;
    }

    public String getMessage() {
        return this.toJson();
    }
}
