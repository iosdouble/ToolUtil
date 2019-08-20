package com.nh.code.util.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * @Classname StringCreateUtil
 * @Description TODO
 * @Date 2019/8/20 10:30 AM
 * @Created by nihui
 */
public class StringCreateUtil {
    public StringCreateUtil() {
    }

    public static String getRandomString(String seedStrs, int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            int number = random.nextInt(seedStrs.length());
            sb.append(seedStrs.charAt(number));
        }

        return sb.toString();
    }

    public static String getRandomString(int length) {
        String strSet = "abcdefghijklmnopqrstuvwxyz0123456789";
        String result = getRandomString(strSet, length);
        return result;
    }

    public static String getRandomNumString(int length) {
        String seedStrs = "0123456789";
        String result = getRandomString(seedStrs, length);
        return result;
    }

    public static String getRandomString(String prefix, int middleLength, String suffix) {
        StringBuffer sb = new StringBuffer();
        if (prefix == null) {
            prefix = "";
        }

        if (suffix == null) {
            suffix = "";
        }

        sb.append(prefix).append(getRandomString(middleLength)).append(suffix);
        return sb.toString();
    }

    public static String getFixedLengthStr(String str, String prefixChar, int length) {
        if (StringUtils.isBlank(prefixChar)) {
            return str;
        } else if (str.length() >= length) {
            return str;
        } else {
            if (prefixChar.length() > 1) {
                prefixChar = prefixChar.substring(0, 1);
            }

            int prefixCharLength = length - str.length();
            StringBuffer resultStr = new StringBuffer();

            for(int i = 0; i < prefixCharLength; ++i) {
                resultStr.append(prefixChar);
            }

            return resultStr.append(str).toString();
        }
    }

    public static String getFixedLengthStrForAbsAndNum(String str, int length) {
        if (str.length() >= length) {
            return str;
        } else {
            int prefixCharLength = length - str.length();
            String prefixStr = getRandomString(prefixCharLength);
            StringBuffer resultStr = new StringBuffer();
            resultStr.append(str).append(prefixStr);
            return resultStr.toString();
        }
    }

    public static String getFixedLengthStrForNum(String str, int length) {
        if (str.length() >= length) {
            return str;
        } else {
            int prefixCharLength = length - str.length();
            String prefixStr = getRandomNumString(prefixCharLength);
            StringBuffer resultStr = new StringBuffer();
            resultStr.append(str).append(prefixStr);
            return resultStr.toString();
        }
    }
}
