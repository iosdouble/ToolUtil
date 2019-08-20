package com.nh.code.web.resp.generator;

import com.nh.code.web.resp.ResultResp;

/**
 * @Classname IResultRespGenerator
 * @Description TODO
 * @Date 2019/8/20 12:20 PM
 * @Created by nihui
 */
public interface IResultRespGenerator {
    <T> ResultResp<T> doResultResp(Throwable var1, T var2);

    <T> ResultResp<T> doResultResp(Throwable var1);

    <T> ResultResp<T> doResultResp(T var1);
}
