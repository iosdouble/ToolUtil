package com.nh.code.web.resp.generator;

import javax.ws.rs.core.Response;

/**
 * @Classname IWsRsResponseGenerator
 * @Description TODO
 * @Date 2019/8/20 12:21 PM
 * @Created by nihui
 */
public interface IWsRsResponseGenerator {
    <T> Response doResponse(Response.Status var1, Throwable var2, T var3);
}
