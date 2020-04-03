package com.tw.utils;

import org.apache.commons.lang3.StringUtils;

public class NumberUtil {
    private static NumberUtil util = new NumberUtil();
    private int id;

    private NumberUtil() {
        this.id = 1000;
    }

    public static String getId() {
        long id = 0;
        synchronized (NumberUtil.util) {
            if (util.id > 9999) util.id = 1000;
            id = ++util.id;
        }
        return String.valueOf(id).substring(1);
    }


    public static String getFormatMobile(String mobile) {
        if (!StringUtils.isEmpty(mobile)) {
            String str1 = mobile.substring(0, 3);
            String str2 = mobile.substring(7);
            return str1 + "****" + str2;
        }
        return "";
    }


}
