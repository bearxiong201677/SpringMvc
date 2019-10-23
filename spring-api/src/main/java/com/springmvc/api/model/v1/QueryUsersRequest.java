package com.springmvc.api.model.v1;


import com.springmvc.api.model.Request;
import com.alibaba.fastjson.JSON;
import java.util.List;

/**
 * Created by xiongbanglong on 2017/4/28.
 */
public class QueryUsersRequest extends Request {
    private List<Integer> userIds;

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public String toString(){
        return "QueryUsersRequest:" + JSON.toJSONString(this);
    }
}
