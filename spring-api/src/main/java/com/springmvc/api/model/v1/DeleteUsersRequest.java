package com.springmvc.api.model.v1;

import com.springmvc.api.model.Request;
import com.springmvc.api.model.UserVo;

import java.util.List;

/**
 * Created by xiongbanglong on 2017/5/10.
 */
public class DeleteUsersRequest extends Request {
    private List<String> usernameList;

    public List<String> getUsernameList() {
        return usernameList;
    }

    public void setUsernameList(List<String> usernameList) {
        this.usernameList = usernameList;
    }
}
