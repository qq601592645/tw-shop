package com.tw.utils;

/**
 * Created by chijr on 16/11/5.
 */
public class CommonException extends Exception {
    private int code;
    private String message;

    public CommonException(int code, String message) {

        this.code = code;
        this.message = message;

    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {

        return this.code;
    }
}
