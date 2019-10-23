package com.springmvc.api.model.v1;

import com.springmvc.api.model.Response;

/**
 * Created by xiongbanglong on 2017/5/5.
 */
public class BaseResponse extends Response {
    public static final BaseResponse SUCCESS = new BaseResponse(true);
    public static final BaseResponse FAILURE = new BaseResponse(false);
    private Boolean status;

    public BaseResponse(Boolean status){
        this.status = status;
    }

    public BaseResponse(String requestId,Boolean status) {
        super(requestId);
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
