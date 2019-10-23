package com.springmvc.api.model.v1;

import com.alibaba.fastjson.JSON;
import com.springmvc.api.model.Response;

/**
 * Created by xiongbanglong on 2017/5/10.
 */
public class CreateUsersResponse extends Response {
    private Boolean status;
    private int row;

    public CreateUsersResponse(){

    }

    public CreateUsersResponse(Boolean status,int row){
        this.status = status;
        this.row = row;
    }

    public CreateUsersResponse(String requestId,Boolean status,int row) {
        super(requestId);
        this.status = status;
        this.row = row;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "CreateUsersResponse:" + JSON.toJSONString(this);
    }
}
