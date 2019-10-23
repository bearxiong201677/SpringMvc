package com.springmvc.api.model.v1;
import com.alibaba.fastjson.JSON;
import com.springmvc.api.model.Request;
import com.springmvc.api.model.UserVo;

import java.util.Date;
import java.util.List;

/**
 * Created by xiongbanglong on 2017/5/5.
 */
public class CreateUsersRequest extends Request {

    private List<UserVo> userList;

    public List<UserVo> getUserList() {
        return this.userList;
    }

    public void setUserList(List<UserVo> userList) {
        this.userList = userList;
    }

    public String toString(){
        return "CreateUsersRequest:" + JSON.toJSONString(this);
    }
}
