package com.tw.helper;

import com.tw.common.base.ResultCode;
import com.tw.common.exception.BaseException;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("WeakerAccess")
public  class DateHelper {
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    public final static String DATE_PATTERN_Y = "yyyy-MM-dd HH:mm:ss";
    
    public static String format(Date date)
    {
        return date == null ? null : format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern)
    {
        return date == null ? null : new SimpleDateFormat(pattern).format(date);
    }

    public static Date parse(String string) throws BaseException {
        return StringUtils.isEmpty(string) ? null : parse(string, DATE_PATTERN);
    }
    public static Date parseDate(String string) throws BaseException {
        return StringUtils.isEmpty(string) ? null : parse(string, DATE_PATTERN_Y);
    }

    public static Date parse(String string, String pattern) throws BaseException {
        try {
            return StringUtils.isEmpty(string) ? null : new SimpleDateFormat(pattern).parse(string);
        } catch (ParseException e) {
            throw  new BaseException(ResultCode.DATE_IS_WRONG);
        }
    }

    public static Date getFirstDay(int year,int month,int date) throws BaseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,date);
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        return  parse(str.toString(), "yyyy-MM-dd");
    }

    /**
     * 当月最后一天
     * @return
     */
    public static Date getLastDay(int year,int month,int date) throws BaseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,date);
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        gcLast.roll(Calendar.DAY_OF_MONTH, -1);
        String day_end = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_end);
        return parse(str.toString(), "yyyy-MM-dd");
    }
    public static Date getLastDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    public static List<String> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<String> lDate = new ArrayList<String>();
        lDate.add(format(beginDate));// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(format(cal.getTime()));
            } else {
                break;
            }
        }
        lDate.add(format(endDate));// 把结束时间加入集合
        return lDate;
    }
//    public static void main(String[] args) {
//
//
//        Date maxDaysByDate = null;
//        try {
//            maxDaysByDate = getLastDay(2012,11,1);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println("2012年11月天数：" + maxDaysByDate);
//    }

}
