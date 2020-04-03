package com.tw.common.base;

import java.util.Date;

public class ResponseObject<T> {
    private Status status;

    private String message;

    private T data;

    public Date getTimestamp() {
        return status == Status.OK ? null : new Date();
    }

    public String getError() {
        return status == Status.OK ? null : status.name();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    } 
}
