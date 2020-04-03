package com.tw.common.helper;


import com.tw.common.base.ResponseObject;
import com.tw.common.base.Status;
import org.springframework.validation.FieldError;

public class FieldErrorHelper {
    public static ResponseObject<?> getResponseObject(FieldError fieldError) {
        ResponseObject<?> responseObject = new ResponseObject<>();
        String errorMessage = fieldError.getField() + fieldError.getDefaultMessage();

        responseObject.setStatus(Status.BadRequest);
        responseObject.setMessage(errorMessage);

        return responseObject;
    }
}
