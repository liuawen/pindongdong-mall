package com.mmall.common;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2019-08-02
 */
public enum ResponseCode {
    //成功 success
    SUCCESS(0,"SUCCESS"),
    //错误 error
    ERROR(1,"ERROR"),
    //需要登录 need login
    NEED_LOGIN(10,"NEED_LOGIN"),
    //非法参数 illegal argument
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
