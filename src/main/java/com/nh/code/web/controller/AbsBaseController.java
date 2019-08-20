package com.nh.code.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Classname AbsBaseController
 * @Description TODO
 * @Date 2019/8/20 11:52 AM
 * @Created by nihui
 */
public class AbsBaseController {
    @Autowired
    protected HttpServletRequest httpServletRequest;
    @Autowired
    protected HttpServletResponse httpServletResponse;
    @Autowired
    protected HttpSession httpSession;

    public AbsBaseController() {
    }

    public HttpServletRequest getHttpServletRequest() {
        return this.httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return this.httpServletResponse;
    }

    public HttpSession getHttpSession() {
        return this.httpSession;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
}
