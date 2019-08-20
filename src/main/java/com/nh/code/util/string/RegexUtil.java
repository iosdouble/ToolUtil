package com.nh.code.util.string;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname RegexUtil
 * @Description TODO
 * @Date 2019/8/20 10:29 AM
 * @Created by nihui
 */
public class RegexUtil {
    private static final String REGEX_EMAIL = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
    private static final String REGEX_DOMESTIC_MOBILE = "0?(13|14|15|17|18)[0-9]{9}";
    private static final String REGEX_SMS_CODE = "[0-9]{4,6}";
    private static final String REGEX_VALIDATE_IMAGE_CODE = "[0-9a-zA-Z]{4,8}";
    private static final String REGEX_PASSWORD = "[^\\s]{6,20}";
    private static final String REGEX_DB_KEY = "[0-9a-zA-Z\\-]{1,50}";

    public RegexUtil() {
    }

    public static boolean regex(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static String getRegexFirstPartStr(String str, String regex) {
        return getRegexPartStr(str, regex, 0);
    }

    public static String getRegexPartStr(String str, String regex, int index) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        for(int i = 0; i < index + 1; ++i) {
            if (matcher.find() && i == index) {
                return matcher.group(0);
            }
        }

        return null;
    }

    public static int getRegexPartCount(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        int result;
        for(result = 0; matcher.find(); ++result) {
            ;
        }

        return result;
    }

    public static boolean isEmail(String email) {
        return StringUtils.isBlank(email) ? false : regex("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}", email);
    }

    public static boolean isDomesticMobile(String mobile) {
        return StringUtils.isBlank(mobile) ? false : regex("0?(13|14|15|17|18)[0-9]{9}", mobile);
    }

    public static boolean isSmsCode(String smsCode) {
        return StringUtils.isBlank(smsCode) ? false : regex("[0-9]{4,6}", smsCode);
    }

    public static boolean isValidateImageCode(String imageCode) {
        return StringUtils.isBlank(imageCode) ? false : regex("[0-9a-zA-Z]{4,8}", imageCode);
    }

    public static boolean isPassword(String password) {
        return StringUtils.isBlank(password) ? false : regex("[^\\s]{6,20}", password);
    }

    public static boolean isDBKey(String dbKey) {
        return StringUtils.isBlank(dbKey) ? false : regex("[0-9a-zA-Z\\-]{1,50}", dbKey);
    }
}
