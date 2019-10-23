package com.springmvc.api.model;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by xiongbanglong on 2017/4/28.
 */
public class Response implements Serializable {
    protected String requestId;

    public Response(){

    }

    public Response(String requestId){
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
