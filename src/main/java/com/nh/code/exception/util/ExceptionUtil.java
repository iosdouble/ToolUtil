package com.nh.code.exception.util;

import com.nh.code.exception.bean.ExceptionMsg;
import com.nh.code.util.json.JsonUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname ExceptionUtil
 * @Description TODO
 * @Date 2019/8/20 2:40 PM
 * @Created by nihui
 */
public class ExceptionUtil {

    public ExceptionUtil() {
    }

    public static ExceptionMsg toServiceException(String exceptionMsg) {
        ExceptionMsg errorMsgBean = (ExceptionMsg)JsonUtil.toObject(exceptionMsg, "/exception", ExceptionMsg.class);
        return errorMsgBean;
    }

    public static boolean isServiceException(String exceptionMsg) {
        return StringUtils.isNoneBlank(new CharSequence[]{exceptionMsg}) && exceptionMsg.contains("error_code");
    }
}
