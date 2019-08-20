package com.nh.code.web.req.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname CookieUtil
 * @Description TODO
 * @Date 2019/8/20 12:11 PM
 * @Created by nihui
 */
public class CookieUtil {
    public CookieUtil() {
    }

    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            Cookie[] var3 = cookies;
            int var4 = cookies.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Cookie cookie = var3[var5];
                cookieMap.put(cookie.getName(), cookie);
            }
        }

        return cookieMap;
    }

    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    public static String getCookieValueByName(HttpServletRequest request, String name) {
        Cookie cookie = getCookieByName(request, name);
        return cookie == null ? null : cookie.getValue();
    }

    public static boolean addCookie(HttpServletResponse response, String name, String value, int maxAge, String domain, String path, boolean isHttpOnly, boolean isSecure) {
        if (StringUtils.isBlank(name)) {
            return false;
        } else {
            name = name.trim();
            if (StringUtils.isNotBlank(value)) {
                value = value.trim();
            }

            Cookie cookie = new Cookie(name, value);
            if (StringUtils.isBlank(value)) {
                cookie.setMaxAge(0);
            } else {
                cookie.setMaxAge(maxAge);
            }

            if (StringUtils.isNotBlank(domain)) {
                cookie.setDomain(domain);
            }

            if (StringUtils.isBlank(path)) {
                cookie.setPath("/");
            } else {
                cookie.setPath(path);
            }

            cookie.setHttpOnly(isHttpOnly);
            cookie.setSecure(isSecure);
            response.addCookie(cookie);
            return true;
        }
    }

    public static boolean addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        String domain1 = null;
        String path1 = null;
        boolean isHttpOnly1 = false;
        boolean isSecure1 = false;
        return addCookie(response, name, value, maxAge, (String)domain1, (String)path1, isHttpOnly1, isSecure1);
    }

    public static void editCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = getCookieByName(request, name);
        cookie.setValue(value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie cookie = getCookieByName(request, name);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
