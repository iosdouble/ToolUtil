package com.nh.code.web.validator;

import org.apache.commons.lang3.StringUtils;

/**
 * @Classname CommonValidator
 * @Description TODO
 * @Date 2019/8/20 2:24 PM
 * @Created by nihui
 */
public class CommonValidator {
    public CommonValidator() {
    }

    public static void validExecute(String execute) {
        if (StringUtils.isBlank(execute)) {
            execute = "basic";
        }

        if (!execute.equals("basic") && !execute.equals("full")) {
            execute = "basic";
        }

    }
}
