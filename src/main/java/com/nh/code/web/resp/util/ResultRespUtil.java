package com.nh.code.web.resp.util;

import com.nh.code.exception.ParentException;
import com.nh.code.exception.ParentRuntimeException;
import com.nh.code.exception.bean.ExceptionMsg;
import com.nh.code.exception.util.ExceptionIdUtil;
import com.nh.code.web.resp.ResultResp;

/**
 * @Classname ResultRespUtil
 * @Description TODO
 * @Date 2019/8/20 2:20 PM
 * @Created by nihui
 */
public class ResultRespUtil {
    public ResultRespUtil() {
    }

    public static <T> ResultResp<T> doResultResp(Throwable throwable, T response) {
        ResultResp<T> resultResp = new ResultResp();
        if (throwable != null) {
            if (ParentException.class.isAssignableFrom(throwable.getClass())) {
                ParentException parentException = (ParentException)throwable;
                resultResp.setStatus("exception");
                resultResp.setException(parentException);
            } else if (ParentRuntimeException.class.isAssignableFrom(throwable.getClass())) {
                ParentRuntimeException parentRuntimeException = (ParentRuntimeException)throwable;
                resultResp.setStatus("exception");
                resultResp.setException(parentRuntimeException);
            } else {
                resultResp.setStatus("error");
                ExceptionMsg exceptionMsg = new ExceptionMsg();
                exceptionMsg.setErrorCode("0");
                exceptionMsg.setErrorId(ExceptionIdUtil.getId());
                exceptionMsg.setErrorMsg(throwable.getMessage());
                resultResp.setExceptionMsg(exceptionMsg);
            }
        }

        resultResp.setResponse(response);
        return resultResp;
    }
}
