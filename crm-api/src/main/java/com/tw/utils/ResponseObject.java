package com.tw.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * Created by chijr on 17/12/13.
 */
public class ResponseObject {


    public static int ResponseCode_Success=200;


    public static int ResponseCode_AUTH_ERROR=401;

    public static int ResponseCode_NOT_FOUNDED=404;
    public static int ResponseCode_PARAM_ERROR=400;


    public static int ResponseCode_APP_ERROE=550;

    public static int ResponseCode_DB_ERROE=560;


    private Object data;

    private final static Logger logger = LoggerFactory.getLogger(ResponseObject.class);



    public static ResponseEntity success(){

        ResponseObject object = new ResponseObject(ResponseCode_Success,"success");


        return  ResponseEntity.status(ResponseCode_Success).body(object);

    }

    public static ResponseEntity error(){

        ResponseObject object = new ResponseObject(ResponseCode_APP_ERROE,"应用错误");


        return  ResponseEntity.status(ResponseCode_APP_ERROE).body(object);


    }


    public static ResponseEntity successWithPage(Object data, PageObject pageObject) {

        ResponseObject object = new ResponseObject(ResponseCode_Success, "success");
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("list", data);
        m.put("page", pageObject);

        object.setData(m);

        return  ResponseEntity.status(ResponseCode_Success).body(object);


    }



    public static ResponseEntity success(Object data){
        ResponseObject object = new ResponseObject(ResponseCode_Success,"success");
        object.setData(data);

        return  ResponseEntity.status(ResponseCode_Success).body(object);


    }

    public static ResponseEntity error(String message){

        ResponseObject object = new ResponseObject(ResponseCode_APP_ERROE,message);

        return  ResponseEntity.status(ResponseCode_APP_ERROE).body(object);


    }



    public static ResponseEntity error(int code,String message){


        ResponseObject object = new ResponseObject(code,message);

        return  ResponseEntity.status(code).body(object);


    }




    public static ResponseEntity error(Exception e){

        ResponseObject object = new ResponseObject(ResponseCode_APP_ERROE,e.getMessage());


        return  ResponseEntity.status(ResponseCode_APP_ERROE).body(object);



    }



//    public static ResponseObject error(int code,String message,Exception e){
//
//        ResponseObject object = new ResponseObject(code,message);
//
//
//        return object;
//
//    }

    public static ResponseEntity success(String key,Object value){

        ResponseObject object = new ResponseObject(ResponseCode_Success,"success");
        HashMap<String,Object> data = new HashMap<String, Object>();
        data.put(key,value);

        object.setData(data);
        return  ResponseEntity.status(ResponseCode_APP_ERROE).body(object);

    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseObject(int status, String message){

        this.status = status;
        this.message = message;

        this.data = new HashMap<String, Object>();
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private  int status;




}
