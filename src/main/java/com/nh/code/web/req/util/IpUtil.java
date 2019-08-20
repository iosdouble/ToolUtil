package com.nh.code.web.req.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname IpUtil
 * @Description TODO
 * @Date 2019/8/20 12:11 PM
 * @Created by nihui
 */
public class IpUtil {
    public IpUtil() {
    }

    public static String getRequestClientIp(HttpServletRequest httpServletRequest) {
        String client_ip = httpServletRequest.getHeader("x-forwarded-for");
        if (null == client_ip || client_ip.length() == 0 || "unknown".equalsIgnoreCase(client_ip)) {
            client_ip = httpServletRequest.getHeader("Proxy-Client-IP");
        }

        if (null == client_ip || client_ip.length() == 0 || "unknown".equalsIgnoreCase(client_ip)) {
            client_ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
        }

        if (null == client_ip || client_ip.length() == 0 || "unknown".equalsIgnoreCase(client_ip)) {
            client_ip = httpServletRequest.getRemoteAddr();
        }

        if (client_ip != null) {
            client_ip = client_ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : client_ip;
        }

        return client_ip;
    }

    public static String getRequestClientRemoteIp(HttpServletRequest httpServletRequest) {
        String ips = getRequestClientIp(httpServletRequest);
        if (StringUtils.isBlank(ips)) {
            return null;
        } else {
            String[] ipArr = ips.split(",");
            if (ipArr != null && ipArr.length > 0) {
                String remoteIp = ipArr[0];
                return remoteIp;
            } else {
                return null;
            }
        }
    }
}
