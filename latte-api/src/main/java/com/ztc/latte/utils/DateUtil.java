package com.ztc.latte.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONTH;

public class DateUtil {

    public DateUtil() {
    }

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String Y_M = "yyyy/MM";
    public static final String Y_M_D = "yyyy/MM/dd";

    /**
     * 转换date格式（默认yyyy-MM-dd HH:mm:ss）
     *
     * @param date 日期
     * @return
     */
    public static String parseDate(Date date) {
        return parseDate(date, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 转换date格式
     *
     * @param date   日期
     * @param format 格式化类型
     * @return
     */
    public static String parseDate(Date date, String format) {
        if (date != null && !"".equals(date)) {
            return new SimpleDateFormat(format).format(date);
        }
        return null;
    }

    /**
     * Long类型日期转Integer类型
     *
     * @param dateLong
     * @param format
     * @return
     */
    public static Integer longToInteger(Long dateLong, String format) {
        if (dateLong != null && !"".equals(dateLong)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = new Date(dateLong);
            return Integer.parseInt(sdf.format(date));
        }
        return null;
    }

    /**
     * Long类型日期转Date类型(yyyy-MM-dd HH:mm:ss)
     *
     * @param dateLong
     * @return
     */
    public static Date longToDate(Long dateLong) {
        return longToDate(dateLong, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * Long类型日期转Date类型
     *
     * @param dateLong
     * @param format
     * @return
     */
    public static Date longToDate(Long dateLong, String format) {
        if (dateLong != null && !"".equals(dateLong)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = new Date(dateLong);
            String d = sdf.format(date);

            try {
                return sdf.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Long类型日期转String类型
     *
     * @param dateLong
     * @param format
     * @return
     */
    public static String longToString(Long dateLong, String format) {
        if (dateLong != null && !"".equals(dateLong)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = new Date(dateLong);
            return sdf.format(date);
        }
        return null;
    }

    /**
     * 获取距离date前beforeTime的日期时间
     *
     * @param date
     * @param beforeTime 毫秒
     * @return
     */
    public static Date beforeDate(Date date, long beforeTime) {
        Long time = date.getTime() - beforeTime;
        return longToDate(time, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取距离date后afterTime的日期时间
     *
     * @param date
     * @param afterTime 毫秒
     * @return
     */
    public static Date afterDate(Date date, long afterTime) {
        Long time = date.getTime() + afterTime;
        return longToDate(time, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取距离date后afterTime的日期时间
     *
     * @param date
     * @param afterTime 毫秒
     * @return
     */
    public static String afterStringDate(Date date, long afterTime) {
        return afterStringDate(date, afterTime, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取距离date后afterTime的日期时间
     *
     * @param date
     * @param afterTime 毫秒
     * @return
     */
    public static String afterStringDate(Date date, long afterTime, String format) {
        Long time = date.getTime() + afterTime;
        return longToString(time, format);
    }

    /**
     * String类型转Date
     *
     * @param sDate   String格式日期
     * @param sFormat 开始的日期格式
     * @param eFormat 结果的日期格式
     * @return
     */
    public static Date stringToDate(String sDate, String sFormat, String eFormat) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(sFormat);
        SimpleDateFormat sdf2 = new SimpleDateFormat(eFormat);
        try {
            Date date = sdf1.parse(sDate);
            String d = sdf2.format(date);
            return sdf2.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * String类型转Date("yyyy-MM-dd -> yyyy-MM-dd HH:mm:ss")
     *
     * @param sDate
     * @return
     */
    public static Date stringToDate(String sDate) {
        return stringToDate(sDate, YYYY_MM_DD, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 距离Date月份的时间
     *
     * @param date
     * @param month
     * @return
     */
    public static Date addMonths(Date date, Integer month) {
        return org.apache.commons.lang3.time.DateUtils.addMonths(date, month);
    }

    /**
     * 距离Date天的时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDays(Date date, Integer day) {
        return org.apache.commons.lang3.time.DateUtils.addDays(date, day);
    }

    /**
     * 日期的00:00:00
     *
     * @param date
     * @return
     */
    public static Date parseDateBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 日期的23:59:59
     *
     * @param date
     * @return
     */
    public static Date parseDateEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 修改日期
     *
     * @param theDate  待修改的日期
     * @param addMonth 加减的月数
     * @return 修改后的日期
     */
    public static Date changeDateOfMonth(Date theDate, int addMonth) {
        if (theDate == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(theDate);

        cal.add(MONTH, addMonth);
        return cal.getTime();
    }

}
