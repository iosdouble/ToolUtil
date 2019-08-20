package com.nh.code.exception.id;

import com.nh.code.util.id.SnowflakeUtil;

/**
 * @Classname SnowflakeExceptionIdGeneratorImpl
 * @Description TODO
 * @Date 2019/8/20 2:36 PM
 * @Created by nihui
 */
public class SnowflakeExceptionIdGeneratorImpl implements IExceptionIdGenerator {
    public SnowflakeExceptionIdGeneratorImpl() {
    }

    public String getId() {
        long id = SnowflakeUtil.getId();
        return String.valueOf(id);
    }
}
