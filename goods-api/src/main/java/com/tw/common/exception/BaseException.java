package com.tw.common.exception;


import com.tw.common.base.ResponseObject;
import com.tw.common.base.ResultCode;

public class BaseException extends Exception {
    private static final long serialVersionUID = -553207758091587433L;
    
    private ResultCode status;


    public BaseException(ResultCode status) {
        super(status.getMsg());
        this.status = status;
    }
    public BaseException(ResultCode status, Exception ex) {
        super(ex);
        this.status = status;
    }

    public ResponseObject<?> buildResponseObject() {
        ResponseObject<?> responseObject = new ResponseObject<>();

        responseObject.setCode(status.getCode());
        responseObject.setMessage(getMessage());

        return responseObject;
    }

    public  <T>ResponseObject<T> buildResponseObject(T data) {
        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setData(data);
        responseObject.setCode(status.getCode());
        responseObject.setMessage(getMessage());
        return responseObject;
    }
}
