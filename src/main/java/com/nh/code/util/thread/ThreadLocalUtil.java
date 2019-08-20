package com.nh.code.util.thread;

/**
 * @Classname ThreadLocalUtil
 * @Description TODO
 * @Date 2019/8/20 10:32 AM
 * @Created by nihui
 */
public class ThreadLocalUtil {
    private static ThreadLocal<Object> t = new ThreadLocal();

    private ThreadLocalUtil() {
    }

    public static ThreadLocal<Object> getInstance() {
        return t;
    }
}
