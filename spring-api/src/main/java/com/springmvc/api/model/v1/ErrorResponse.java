package com.springmvc.api.model.v1;

import com.alibaba.fastjson.JSON;
import com.springmvc.api.model.Response;

/**
 * Created by xiongbanglong on 2017/5/4.
 */
public class ErrorResponse extends Response {
    protected String code;
    protected String message;

    public ErrorResponse() {

    }

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(int code, String message) {
        this.code = String.valueOf(code);
        this.message = message;
    }

    public ErrorResponse(String requestId, String code, String message) {
        super(requestId);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString(){
        return "ErrorResponse:" + JSON.toJSONString(this);
    }
}
