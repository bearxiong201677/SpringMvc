package com.springmvc.service;

import com.springmvc.api.model.UserVo;
import com.springmvc.api.model.v1.CreateUsersResponse;
import com.springmvc.api.model.v1.DeleteUsersResponse;
import com.springmvc.api.model.v1.QueryUsersRequest;
import com.springmvc.api.model.v1.QueryUsersResponse;

import java.util.List;

/**
 * Created by xiongbanglong on 2017/4/14.
 */
public interface UserService {

    QueryUsersResponse queryUsers(List<Integer> idList);
    CreateUsersResponse batchCreateUsers(List<UserVo> userVoList);
    DeleteUsersResponse batchDeleteUsers(List<String> usernameList);
}
