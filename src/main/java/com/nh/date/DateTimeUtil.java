package com.nh.date;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * @Classname DataTimeUtil
 * @Description TODO 时间格式化操作
 * @Date 2019/7/22 4:54 PM
 * @Created by nihui
 */
public class DateTimeUtil {
    public static final String FORMAT_DATETIME_NORMAL = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_NORMAL = "yyyy-MM-dd";
    public static final String FORMAT_DATE_CHINA = "yyyy年MM月dd日";
    public static final String FORMAT_DATE_NUMBER = "yyyy/MM/dd";
    public static final String FORMAT_DATE_SMALL = "yyyyMMdd";

    public DateTimeUtil() {
    }

    public static Date getNowDateTime4BeiJing() {
        Clock clock = Clock.system(ZoneId.of("+08"));
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        return date;
    }

    public static Date getNowDateTime4UTC() {
        Clock clock = Clock.system(ZoneOffset.UTC);
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        return date;
    }

    public static String getFormatDateTime(Date date, String dateFormat) {
        if (date == null) {
            return null;
        } else {
            if (StringUtils.isBlank(dateFormat)) {
                dateFormat = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            String dateStr = sdf.format(date);
            return dateStr;
        }
    }

    public static Date getFormatDateTime(String dateStr, String sourceDateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(sourceDateFormat);
        Date date = null;

        try {
            date = sdf.parse(dateStr);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return date;
    }

    public static String getMonthLastDay(String year, String month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(1, Integer.parseInt(year));
        ca.set(2, Integer.parseInt(month) - 1);
        ca.set(5, ca.getActualMaximum(5));
        return format.format(ca.getTime());
    }

    public static long changeToTimeMillis(String date) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = format.parse(date);
        return dateTime.getTime();
    }
}
