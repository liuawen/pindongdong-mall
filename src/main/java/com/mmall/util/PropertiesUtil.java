package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2019-08-02
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;
/*//eg:说明 静态块  和JDBC 加载Diver样的  去Shift Shift 搜索 Driver class
    public static void main(String[] args) {
//        JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
    //静态块怎么使用 一加载？？？
    //静态代码块  优于普通代码块 优于构造器代码块  静态代码块只初始化  静态变量
    static {
        //
        String fileName = "mmall.properties";
        props = new Properties();
        //捕获异常
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }

    //key  value 获取
    public static String getProperty(String key){
        //去空
        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }
    // 重载
    public static String getProperty(String key,String defaultValue){

        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }



}
