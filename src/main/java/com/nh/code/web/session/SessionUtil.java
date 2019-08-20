package com.nh.code.web.session;

import javax.servlet.http.HttpSession;

/**
 * @Classname SessionUtil
 * @Description TODO
 * @Date 2019/8/20 2:22 PM
 * @Created by nihui
 */
public class SessionUtil {
    public SessionUtil() {
    }

    public static <T> T getObject(HttpSession httpSession, String attrName, Class<T> clazz) {
        Object object = httpSession.getAttribute(attrName);
        return object != null ? (T) object : null;
    }
}
