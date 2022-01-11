package com.xiaorui.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间格式转化工具类
 * @Author: xp
 * @Date: 2021/3/27 15:22
 * @Version: 1.0
 **/
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HHmmss");
    private static final DateTimeFormatter SHORT_MILLISECOND = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    private static final DateTimeFormatter SHORT_DATETIME = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final DateTimeFormatter DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter SHORT_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public enum TimeType {
        HOUR, MINUTE, SECOND
    }

    public static long reduceDate(Date date1, Date date2, TimeType timeType) {
        long time = date1.getTime() - date2.getTime();
        if (timeType.equals(TimeType.HOUR)) {
            return (time/(3600*1000));
        }
        if (timeType.equals(TimeType.MINUTE)) {
            return (time/(60*1000));
        }
        return time/1000;
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String format(Date date, String format) {
        if (date == null) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Date parse(String date) throws ParseException {
        return parse(date, "yyyy-MM-dd");
    }

    public static Date parse(String date, String format) throws ParseException {
        if (StringUtils.isEmpty(date)) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }

    public static String getDateNow() {
        return LocalDate.now().format(DATE);
    }

    public static String getShortDateNow() {
        return LocalDate.now().format(SHORT_DATE);
    }

    public static String getShortTimeNow() {
        return LocalDateTime.now().format(TIME);
    }

    public static String getDateTimeNow() {
        return LocalDateTime.now().format(DATETIME);
    }

    public static String getShortDateTimeNow() {
        return LocalDateTime.now().format(SHORT_DATETIME);
    }

    public static String getYmdhmss() {
        return LocalDateTime.now().format(SHORT_MILLISECOND);
    }

    public static String getPlusDay(String day, int plusDays) {
        LocalDate localDate = LocalDate.parse(day).plusDays(plusDays);
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }

    public static String getAfterMonthDay(String monthDay, int index) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(monthDay);

        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 + index);

        return new SimpleDateFormat("yyyy=MM-dd").format(c.getTime());
    }

    public static String getWeek(String dates) throws ParseException{
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date d = f.parse(dates);
        cal.setTime(d);
        int weekday=cal.get(Calendar.DAY_OF_WEEK)-1;
        String []s={"星期天","星期一","星期二","星期三","星期四","星期五","星期六",};
        return s[weekday];
    }

    public static Integer twoDaysInterval(Date day1, Date day2) {
        long time1 = day1.getTime();
        long time2 = day2.getTime();
        long time3 = Math.abs(time1-time2);

        return getDay(time3);
    }
    //将两个日期之间的毫秒数换算成天数
    private static int getDay(long time) {
        int day = (int)(time/1000/60/60/24);
        return day;
    }

}
