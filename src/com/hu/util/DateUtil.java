package com.hu.util;


import java.util.Calendar;

public class DateUtil {

    /**
     * 返回当前月第一天
     */
    public static String getNowMonthBeginTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        String str = year+"-"+(month+1)+"-01 00:00:00";
        if(month+1<10){
            str = year+"-0"+(month+1)+"-01 00:00:00";
        }
        return str;
    }

    /**
     * 返回当前年上半年第一天
     */
    public static String getNowYearBeginTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String str = year+"-01-01 00:00:00";
        return str;
    }

    /**
     * 返回当前年上半年最后第一天
     */
    public static String getNowYearEndTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String str = year+"-06-30 23:59:59";
        return str;
    }


    /**
     * 返回去年第一天
     */
    public static String getLastYearBeginTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String str = (year-1)+"-01-01 00:00:00";
        return str;
    }

    /**
     * 返回去年最后一天
     */
    public static String getLastYearEndTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String str = (year-1)+"-12-31 23:59:59";
        return str;
    }


    public static void main(String[] args) {
        System.out.println(getNowMonthBeginTime());
    }
}
