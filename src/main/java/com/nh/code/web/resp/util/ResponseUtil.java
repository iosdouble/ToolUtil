package com.nh.code.web.resp.util;

import com.nh.code.exception.ParentException;
import com.nh.code.exception.bean.ExceptionMsg;
import com.nh.code.exception.util.ExceptionIdUtil;
import com.nh.code.web.resp.ResultResp;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname ResponseUtil
 * @Description TODO
 * @Date 2019/8/20 2:19 PM
 * @Created by nihui
 */
public class ResponseUtil {

    public static void doResponse(HttpServletResponse httpServletResponse, int status, String msg) throws IOException {
        doResponse(httpServletResponse, status, (String)null, msg);
    }

    public static void doResponse(HttpServletResponse httpServletResponse, int status, String contentType, String msg) throws IOException {
        httpServletResponse.setStatus(status);
        if (!StringUtils.isBlank(contentType)) {
            httpServletResponse.setContentType(contentType);
        }

        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.write(msg);
        printWriter.flush();
        printWriter.close();
    }

    public static <T> Response doResponse(Response.Status status, ParentException parentException, T response) {
        ResultResp<T> resultResp = doResultResp(parentException, response);
        return Response.status(status).entity(resultResp.toString()).build();
    }

    public static <T> ResultResp<T> doResultResp(ParentException parentException, T response) {
        ResultResp<T> resultResp = new ResultResp();
        if (parentException != null) {
            resultResp.setStatus("exception");
            resultResp.setException(parentException);
        }

        resultResp.setResponse(response);
        return resultResp;
    }

    public static <T> ResultResp<T> doResultResp(Throwable error, boolean includeStackTrace) {
        ResultResp<T> resultResp = new ResultResp();
        resultResp.setStatus("error");
        ExceptionMsg exceptionMsg = new ExceptionMsg();
        exceptionMsg.setErrorCode("0");
        exceptionMsg.setErrorId(ExceptionIdUtil.getId());
        exceptionMsg.setErrorMsg(error.getMessage());
        resultResp.setExceptionMsg(exceptionMsg);
        return resultResp;
    }
}
