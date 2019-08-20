package com.nh.code.exception.util;

import java.util.UUID;

/**
 * @Classname ExceptionIdUtil
 * @Description TODO
 * @Date 2019/8/20 2:40 PM
 * @Created by nihui
 */
public class ExceptionIdUtil {
    public ExceptionIdUtil() {
    }

    public static String getId() {
        String id = UUID.randomUUID().toString();
        return id;
    }
}
