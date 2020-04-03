package com.tw.common.exception;

import com.tw.common.base.Status;
import org.springframework.util.StringUtils;

public class RequestException extends BaseException {
    private static final long serialVersionUID = -623771776999643766L;

    public RequestException(Status status) {
        super(status);
    }

    public RequestException(Status status, String message) {
        super(status, message);
    }

    public static void checkPresent(String fieldName, String value) throws RequestException {
        if (StringUtils.isEmpty(value)) {
            throw new RequestException(Status.BadRequest, String.format("{}不能为空", fieldName));
        }
    }

    public static <T> void checkPresent(String fieldName, T value) throws RequestException {
        if (value == null) {
            throw new RequestException(Status.BadRequest, String.format("{}不能为null", fieldName));
        }
    }

    public static RequestException badRequest() {
        return new RequestException(Status.BadRequest);
    }

    public static RequestException badRequest(String message) {
        return new RequestException(Status.BadRequest, message);
    }
}
