package com.springmvc.api.model.v1;

import com.alibaba.fastjson.JSON;
import com.springmvc.api.model.Response;

/**
 * Created by xiongbanglong on 2017/5/10.
 */
public class DeleteUsersResponse extends Response {
    private Boolean status;
    private int row;

    public DeleteUsersResponse(){

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
        return "DeleteUsersResponse:" + JSON.toJSONString(this);
    }
}
