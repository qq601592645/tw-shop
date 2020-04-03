package com.tw.common.exception;


import com.tw.common.base.Status;

public class APIException extends BaseException {
    private static final long serialVersionUID = -5108404932209836762L;

    public APIException(Status status) {
        super(status);
    }

    public static APIException forbidden() {
        return new APIException(Status.Forbidden);
    }

    public static APIException forbidden(String message) {
        return new APIException(Status.Forbidden, message);
    }

    public static APIException notFound() {
        return new APIException(Status.NotFound);
    }

    public static APIException notFound(String message) {
        return new APIException(Status.NotFound, message);
    }

    public APIException(Status status, String message) {
        super(status, message);
    }

    public static APIException internalServerError() {
        return new APIException(Status.InternalServerError);
    }

    public static APIException internalServerError(String message) {
        return new APIException(Status.InternalServerError, message);
    }
}
