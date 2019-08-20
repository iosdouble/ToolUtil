package com.nh.code.exception.id;

import com.nh.code.util.id.UUIDUtil;

/**
 * @Classname UUIDExceptionIdGeneratorImpl
 * @Description TODO
 * @Date 2019/8/20 2:37 PM
 * @Created by nihui
 */
public class UUIDExceptionIdGeneratorImpl implements IExceptionIdGenerator {
    public UUIDExceptionIdGeneratorImpl() {
    }

    public String getId() {
        String id = UUIDUtil.getId();
        return id;
    }
}
