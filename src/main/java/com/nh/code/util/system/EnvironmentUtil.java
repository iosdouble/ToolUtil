package com.nh.code.util.system;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Classname EnvironmentUtil
 * @Description TODO
 * @Date 2019/8/20 10:31 AM
 * @Created by nihui
 */
public class EnvironmentUtil {
    public EnvironmentUtil() {
    }

    public static String getHostNameForLiunx() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException var3) {
            String host = var3.getMessage();
            if (host != null) {
                int colon = host.indexOf(58);
                if (colon > 0) {
                    return host.substring(0, colon);
                }
            }

            return "UnknownHost";
        }
    }

    public static String getHostName() {
        return System.getenv("COMPUTERNAME") != null ? System.getenv("COMPUTERNAME") : getHostNameForLiunx();
    }
}
