package com.tw.common.base;

public enum Status {
    OK(200),
    BadRequest(400),
    Unauthorized(401),
    Forbidden(403),
    NotFound(404),
    InsufficientStock(405),//库存不足
    RequestTimeout(408),
    InternalServerError(500),
    NotImplemented(501),
    ServiceUnavailable(503);

    private final static Status[] VALUES = Status.values();

    private int value;

    public int getValue() {
        return value;
    }

    Status(int value) {
        this.value = value;
    }

    public static Status valueOf(int value) {
        for (Status status : VALUES) {
            if (status.getValue() == value) {
                return status;
            }
        }

        return null;
    }

    public static String getDefaultMessage(Status status) {
        switch (status) {
            case OK: return "success";
            case NotFound: return "data not found";
            default: return null;
        }
    }

    public <T> ResponseObject<T> getDefaultResponseObject() {
        ResponseObject<T> responseObject = new ResponseObject<>();
        String defaultMessage = getDefaultMessage(this);

        responseObject.setStatus(this);
        responseObject.setMessage(defaultMessage);

        return responseObject;
    }

    public <T> ResponseObject<T> getResponseObject(T data) {
        ResponseObject<T> responseObject = new ResponseObject<>();

        responseObject.setStatus(this);
        responseObject.setData(data);

        return responseObject;
    }

    public <T> ResponseObject<T> getResponseObject(String message) {
        ResponseObject<T> responseObject = new ResponseObject<>();

        responseObject.setStatus(this);
        responseObject.setMessage(message);

        return responseObject;
    }

    public <T> ResponseObject<T> getResponseObject(T data, String message) {
        ResponseObject<T> responseObject = new ResponseObject<>();

        responseObject.setStatus(this);
        responseObject.setMessage(message);
        responseObject.setData(data);

        return responseObject;
    }
}
