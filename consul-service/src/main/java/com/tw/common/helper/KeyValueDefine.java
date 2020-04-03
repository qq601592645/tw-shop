package com.tw.common.helper;

/**
 * Created by oracle on 17/1/18.
 */
public class KeyValueDefine {
    public static final int RETURN_PACKAGE_SUCCESS_CODE = 200;
    public static final String RETURN_PACKAGE_SUCCESS_MESSAGE = "success";

    public static final String RETURN_PACKAGE_LIST = "list";
    public static final String RETURN_PACKAGE_DATA = "data";
    public static final String RETURN_PACKAGE_IMAGE = "image";
    public static final String RETURN_PACKAGE_IMAGES = "images";

    public static final String STATUS_AVAILABLE = "Y";
    public static final String STATUS_UNAVAILABLE = "N";

    public static final int STATUS_TRANSLINE_INIT = 0;
    public static final int STATUS_TRANSLINE_SUCCESS = 1;
    public static final int STATUS_TRANSLINE_FAILED = -1;
    public static final int STATUS_TRANSLINE_REVERSE = 99;

    public static final int ACCOUNT_MONEY_REDUCE = -1;
    public static final int ACCOUNT_MONEY_ADD = 1;


    public static final String STATUS_COMFIRMCASHOUT_SUCCESS = "Y";
    public static final String STATUS_COMFIRMCASHOUT_FAILED = "N";

    public static final int STATUS_ACCOUNTLINE_SUCCESS = 1;
    public static final int STATUS_ACCOUNTLINE_FAILED = -1;
    public static final int STATUS_ACCOUNTLINE_REVERSE = 99;

    //现金账户
    public static final String ACCOUNT_TYPE_CASH = "CASH"; //现金子账户
    public static final String ACCOUNT_TYPE_RETURN = "RETURN"; //返现子账户
    public static final String ACCOUNT_TYPE_FREEZE = "FREEZE"; //冻结子账户
    public static final String ACCOUNT_TYPE_STOCK = "STOCK"; //股份子账户
    public static final String ACCOUNT_TYPE_CREDIT = "CREDIT"; //授信子账户

    //积分账户
    public static final String ACCOUNT_TYPE_POINT = "POINT"; //积分子账户

    //参数
    public static final String PARAM_STATUS_COMFIRMCASHOUT = "statuscomfirmcashout";
    public static final String PARAM_AMOUNT = "amount"; //金额,单位:元
    public static final String PARAM_POINT = "point"; //积分
    public static final String PARAM_USERNAME = "username"; //用户名
    public static final String PARAM_USERID = "userid"; //用户ID
    public static final String PARAM_USERNAME_NEW = "newusername"; //用户名,注册时候使用
    public static final String PARAM_TARGET_USERNAME = "targetusername"; //目标用户名
    public static final String PARAM_GLOBLE_TRACE = "globletrace"; //全局流水号
    public static final String PARAM_SYSTEM_TRACE = "systemtrace"; //系统流水号
    public static final String PARAM_PASSWD = "passwd"; //用户密码
    public static final String PARAM_BEGINROW = "beginrow"; //开始序号
    public static final String PARAM_ROWSIZE = "rowsize"; //返回条数
    public static final String PARAM_BEGIN_DATE = "begindate"; //开始时间
    public static final String PARAM_END_DATE = "enddate"; //结束时间

    public static final String TASK_NAME_RETURNCASH = "RETURN_CASH"; //返现任务

    public static final String TASK_STATUS_BEGIN = "BEGIN"; //任务开始
    public static final String TASK_STATUS_END = "END"; //任务结束
}
