package com.nh.code.web.resp.util;

import com.nh.code.exception.ParentException;
import com.nh.code.web.resp.ResultResp;

import javax.ws.rs.core.Response;

/**
 * @Classname WsRsResponseUtil
 * @Description TODO
 * @Date 2019/8/20 2:21 PM
 * @Created by nihui
 */
public class WsRsResponseUtil {
    public WsRsResponseUtil() {
    }

    public static <T> Response doResultResp(Response.Status status, ParentException parentException, T response) {
        ResultResp<T> resultResp = ResultRespUtil.doResultResp(parentException, response);
        return Response.status(status).entity(resultResp.toString()).build();
    }
}
