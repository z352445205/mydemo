package com.example.demo.globalUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/10 11:00
 */
public class DateUtil {

    /**
     * 获取当前月份
     * */
    public static String getDateThisMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
    }

    /**
     * 获取去年12月
     * */
    public static String getLastYearDecember() {
        return LocalDate.now().minus(1, ChronoUnit.YEARS).getYear()+"-12";

    }

    /**
     * 获取今天
     * */
    public static String getDateToday() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 获取当前时间
     * */
    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

}
