package com.nh.code.web.resp.generator;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ISpringResponseGenerator
 * @Description TODO
 * @Date 2019/8/20 12:21 PM
 * @Created by nihui
 */
public interface ISpringResponseGenerator {
    void doResponse(HttpServletResponse var1, int var2, String var3) throws IOException;

    void doResponse(HttpServletResponse var1, int var2, String var3, String var4) throws IOException;
}
