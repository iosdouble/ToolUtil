package com.nh.code.web.resp.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname SpringResponseUtil
 * @Description TODO
 * @Date 2019/8/20 2:20 PM
 * @Created by nihui
 */
public class SpringResponseUtil {
    public SpringResponseUtil() {
    }

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
}
