package com.springmvc.api.model;

import java.io.Serializable;

/**
 * Created by xiongbanglong on 2017/4/28.
 */
public class Request implements Serializable,Cloneable{
    private String id;
    protected String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


}
