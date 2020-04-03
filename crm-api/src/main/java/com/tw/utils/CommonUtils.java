package com.tw.utils;


import org.springframework.util.StringUtils;

public class CommonUtils {
    public static String getFormatUrl(String url) {
        if (url.startsWith("http:")) {
            url = StringUtils.replace(url, "http", "https");
        }

        return url;
    }


}
