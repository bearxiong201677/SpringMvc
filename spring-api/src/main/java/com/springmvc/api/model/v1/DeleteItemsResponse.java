package com.springmvc.api.model.v1;

import com.springmvc.api.model.Response;

/**
 * Created by xiongbanglong on 2017/5/15.
 */
public class DeleteItemsResponse extends Response {
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
}
