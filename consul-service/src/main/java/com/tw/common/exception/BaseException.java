package com.tw.common.exception;


import com.tw.common.base.ResponseObject;
import com.tw.common.base.Status;

public class BaseException extends Exception {
    private static final long serialVersionUID = -553207758091587433L;
    
    private Status status;
    
    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    public BaseException(Status status) {
        super();

        this.status = status;
    }

    public BaseException(Status status, String message) {
        super(message);

        this.status = status;
    }
    
    public ResponseObject<?> buildResponseObject() {
        ResponseObject<?> responseObject = new ResponseObject<>();

        responseObject.setStatus(status);
        responseObject.setMessage(getMessage());

        return responseObject;
    }
}
