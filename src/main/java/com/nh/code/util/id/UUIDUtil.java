package com.nh.code.util.id;

import java.util.UUID;

/**
 * @Classname UUIDUtil
 * @Description TODO
 * @Date 2019/8/20 2:38 PM
 * @Created by nihui
 */
public class UUIDUtil {
    public UUIDUtil() {
    }

    public static String getId() {
        String id = UUID.randomUUID().toString();
        return id;
    }
}
