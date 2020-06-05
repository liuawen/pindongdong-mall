package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2019-08-02
 * 年 月 日 时 分 秒
 * 时间转换  
 */
public class DateTimeUtil {

    //joda-time

    //str->Date
    //Date->str

    //standard_format
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";


    //str->Date
    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
    //str ->date
    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    //date ->str
    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    //date ->str
    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }




    public static void main(String[] args) {
        System.out.println(DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.dateToStr(new Date(),STANDARD_FORMAT));
        System.out.println(DateTimeUtil.strToDate("1111-11-11 11:11:11","yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.strToDate("1111-11-11 11:11:11",STANDARD_FORMAT));
        //eg:
        //2020-06-05 11:20:49
        //2020-06-05 11:20:49
        //Sat Nov 04 11:05:14 CST 1111
        //Sat Nov 04 11:05:14 CST 1111
    }


}
