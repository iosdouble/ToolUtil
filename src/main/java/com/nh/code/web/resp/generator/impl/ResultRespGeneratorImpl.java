package com.nh.code.web.resp.generator.impl;

import com.nh.code.exception.ParentException;
import com.nh.code.exception.ParentRuntimeException;
import com.nh.code.exception.bean.ExceptionMsg;
import com.nh.code.exception.code.IExceptionCodeGenerator;
import com.nh.code.exception.id.IExceptionIdGenerator;
import com.nh.code.web.resp.ResultResp;
import com.nh.code.web.resp.generator.IResultRespGenerator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Classname ResultRespGeneratorImpl
 * @Description TODO
 * @Date 2019/8/20 2:17 PM
 * @Created by nihui
 */
public class ResultRespGeneratorImpl implements IResultRespGenerator {
    @Autowired
    private IExceptionIdGenerator exceptionIdGenerator;
    @Autowired
    private IExceptionCodeGenerator exceptionCodeGenerator;

    public ResultRespGeneratorImpl() {
    }

    public <T> ResultResp<T> doResultResp(Throwable throwable, T response) {
        ResultResp<T> resultResp = new ResultResp();
        if (throwable != null) {
            if (ParentException.class.isAssignableFrom(throwable.getClass())) {
                ParentException parentException = (ParentException)throwable;
                parentException.setErrorId(this.exceptionIdGenerator.getId());
                parentException.setErrorCode(this.exceptionCodeGenerator.getProjectExceptionCode());
                resultResp.setStatus("exception");
                resultResp.setException(parentException);
            } else if (ParentRuntimeException.class.isAssignableFrom(throwable.getClass())) {
                ParentRuntimeException parentRuntimeException = (ParentRuntimeException)throwable;
                parentRuntimeException.setErrorId(this.exceptionIdGenerator.getId());
                parentRuntimeException.setErrorCode(this.exceptionCodeGenerator.getProjectExceptionCode());
                resultResp.setStatus("exception");
                resultResp.setException(parentRuntimeException);
            } else {
                resultResp.setStatus("error");
                ExceptionMsg exceptionMsg = new ExceptionMsg();
                exceptionMsg.setErrorCode(this.exceptionCodeGenerator.getProjectExceptionCode() + "-0");
                exceptionMsg.setErrorId(this.exceptionIdGenerator.getId());
                exceptionMsg.setErrorMsg(throwable.getMessage());
                resultResp.setExceptionMsg(exceptionMsg);
                throwable.printStackTrace();
            }
        }

        resultResp.setResponse(response);
        return resultResp;
    }

    public <T> ResultResp<T> doResultResp(Throwable throwable) {
        ResultResp<T> resultResp = this.doResultResp(throwable,null);
        return resultResp;
    }

    public <T> ResultResp<T> doResultResp(T response) {
        ResultResp<T> resultResp = this.doResultResp((Throwable)null, response);
        return resultResp;
    }
}
