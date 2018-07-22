package com.yang.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.lang.Integer.parseInt;

public class DateUtil {

    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    public static final String DATE_DEFAULT_MONTH_FORMAT = "yyyy-MM";

    public static final String DATE_OTHER_FORMAT = "yyyy/MM/dd";

    public static final String DATE_OTHER_MONTH_FORMAT = "yyyy/MM";

    public static final String DATE_YEAR_FORMAT = "yyyy";

    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_OTHER_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";

    public static final String DATE_DAY_FORMAT = "MM/dd";

    public static final String DATE_DAY_CHINA_FORMAT = "MM月dd号";

    private static String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

    /**
     * 获取当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    public static String getWeekOfDate(String dateStr) {
        Date date = dateFromString(dateStr, DATE_DEFAULT_FORMAT);
        return getWeekOfDate(date);
    }

    /**
     * 判断是否为同一天1
     */
    public static boolean isSameDay(Date aDate, Date bDate) {
        if (aDate == null || bDate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(aDate).equals(sdf.format(bDate));
    }

    /**
     * 判断是否为同一天2
     */
    public static boolean isSameDay2(Date date1, Date date2) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(date1);
        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(date2);
        return isSameDay3(calDateA, calDateB);
    }

    /**
     * 判断是否为同一天3
     */
    public static boolean isSameDay3(Calendar calDateA, Calendar calDateB) {
        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
                && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 判断是否为同一年
     */
    public static boolean isSameYear(Date aDate, Date bDate) {
        if (aDate == null || bDate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(aDate).equals(sdf.format(bDate));
    }

    /**
     * 获取上个月第一天的方法
     */
    public static String getLastMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return yyyy_MM_dd(calendar);
    }

    /**
     * 获取上个月最后一天的方法, 拿到这个月第一天，再往前一天就是上个月最后一天
     */
    public static String getLastMonthLastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return yyyy_MM_dd(calendar);
    }

    public static String yyyy_MM_dd(Calendar aCalendar) {
        String yearStr = aCalendar.get(Calendar.YEAR) + "";//获取年份
        int month = aCalendar.get(Calendar.MONTH) + 1;//获取月份
        String monthStr = month < 10 ? "0" + month : month + "";
        int day = aCalendar.get(Calendar.DATE);//获取日
        String dayStr = day < 10 ? "0" + day : day + "";
        return yearStr + "-" + monthStr + "-" + dayStr;
    }

    public static Date dateFromString(String str, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String stringFromDate(Date date, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getDaySinceToday(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, amount);
        return yyyy_MM_dd(calendar);
    }

    public static void main(String[] args) {
//        String dateStr = "2018-07-14";
//        Date dt = dateFromString(dateStr, DATE_DEFAULT_FORMAT);
//        System.out.println(dateStr + " 是 " + getWeekOfDate(dt));
//        System.out.println("上个月第一天是 " + getLastMonthFirstDate());
//        System.out.println("上个月最后一天是 " + getLastMonthLastDate());
//        System.out.println("昨天是 " + getDaySinceToday(-1));
//        System.out.println("明天是 " + getDaySinceToday(1));

        String yearMonth = "2018-08";
        String yyyy = yearMonth.split("-")[0];
        String mm = yearMonth.split("-")[1];
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.set(parseInt(yyyy), parseInt(mm), 0);
        int dayOfMonth = aCalendar.get(Calendar.DAY_OF_MONTH);//这个月有多少天
        String dayOfMonthStr = dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth + "";
        System.out.println(yearMonth + "-" + dayOfMonthStr);

        Long a = null;
        System.out.println(a.intValue());
    }
}
