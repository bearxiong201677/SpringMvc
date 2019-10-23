package com.springmvc.api.model.v1;

import com.alibaba.fastjson.JSON;
import com.springmvc.api.model.Response;

/**
 * Created by xiongbanglong on 2017/5/11.
 */
public class AddItemsResponse extends Response {
    private int row;
    private Boolean status;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddItemsResponse:" + JSON.toJSONString(this);
    }
}
