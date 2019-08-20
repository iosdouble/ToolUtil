package com.nh.code.web.req.util;

import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname AjaxUtil
 * @Description TODO
 * @Date 2019/8/20 12:10 PM
 * @Created by nihui
 */
public class AjaxUtil {
    public AjaxUtil() {
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String header0 = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(header0)) {
            return true;
        } else {
            String header1 = request.getHeader("accept");
            return header1 != null && header1.contains("application/json");
        }
    }

    public static boolean isAjaxRequest(WebRequest request) {
        String header0 = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(header0)) {
            return true;
        } else {
            String header1 = request.getHeader("accept");
            return header1 != null && header1.contains("application/json");
        }
    }
}
