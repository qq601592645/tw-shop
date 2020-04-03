package com.tw.common.base;

/**
 * Created by aisiA on 2019/4/3.
 */
public class AppResultBuilder {

    //成功，不返回具体数据
    public static <T> ResponseObject<T> successNoData(){
        ResponseObject<T> result = new ResponseObject<T>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMsg());
        return result;
    }
    //成功，返回数据
    public static <T> ResponseObject<T> success(T t){
        ResponseObject<T> result = new ResponseObject<T>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMsg());
        result.setData(t);
        return result;
    }

}
