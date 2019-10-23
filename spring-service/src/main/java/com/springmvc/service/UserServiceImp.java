package com.springmvc.service;

import com.springmvc.api.exception.BusinessException;
import com.springmvc.api.model.ResponseStatus;
import com.springmvc.api.model.UserExample;
import com.springmvc.api.model.UserVo;
import com.springmvc.api.model.v1.CreateUsersResponse;
import com.springmvc.api.model.v1.DeleteUsersResponse;
import com.springmvc.api.model.v1.QueryUsersResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.springmvc.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.dao.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiongbanglong on 2017/4/13.
 */

@Service("UserService")
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * @param userIdList 查询的用户id列表
     * @return QueryUsersResponse
     */
    @Transactional
    public QueryUsersResponse queryUsers(List<Integer> userIdList){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(userIdList != null && userIdList.size() >=1){
            criteria.andIdIn(userIdList);
        }

        List<User> users = userRepository.selectByExample(example);
        QueryUsersResponse queryUsersResponse = new QueryUsersResponse();
        List<QueryUsersResponse.UserInfo> userInfos = new ArrayList<QueryUsersResponse.UserInfo>();
        for(User user:users){
            QueryUsersResponse.UserInfo userInfo = new QueryUsersResponse.UserInfo();
            userInfo.setId(user.getId());
            userInfo.setUsername(user.getUsername());
            userInfo.setSex(user.getSex());
            userInfo.setBirthday(user.getBirthday());
            userInfo.setAddress(user.getAddress());
            userInfos.add(userInfo);
        }

        queryUsersResponse.setInfos(userInfos);
        return queryUsersResponse;
    }

    /**
     * @param userVoList 待创建的用户列表
     * @return CreateUsersResponse
     */
    @Transactional
    public CreateUsersResponse batchCreateUsers(List<UserVo> userVoList){
        List<User> userList = new ArrayList<User>();
        for(UserVo userVo:userVoList){
            User user = new User();
            BeanUtils.copyProperties(userVo,user);
            userList.add(user);
        }

        //批量创建用户去重校验，如果有任意用户已经存在则抛出异常
        List<String> usersExistList = new ArrayList<String>();
        for(User userCheck : userList){
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(userCheck.getUsername());
            List<User> usersExist = new ArrayList<User>();
            usersExist = userRepository.selectByExample(example);
            if(usersExist.size() >= 1){
                usersExistList.add(userCheck.getUsername());
            }
        }

        if(usersExistList.size() >= 1){
            throw new BusinessException(ResponseStatus.Invalid.getCode(), "users:" + usersExistList.toString() + " already exist");
        }

        int row = userRepository.batchInsert(userList);
        CreateUsersResponse createUsersResponse = new CreateUsersResponse();
        if(row > 0 && row == userVoList.size()){
            createUsersResponse.setRow(row);
            createUsersResponse.setStatus(true);
        }else{
            createUsersResponse.setRow(row);
            createUsersResponse.setStatus(false);
        }

        return createUsersResponse;
    }

    /**
     * @param usernameList 待删除的用户名列表
     * @return DeleteUsersResponse
     */
    @Transactional
    public DeleteUsersResponse batchDeleteUsers(List<String> usernameList){
        //检查待删除的用户是否存在，如果不存在则抛出异常
        List<String> usersNotExist = new ArrayList<String>();
        for(String username : usernameList){
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(username);
            List<User> usersExist = userRepository.selectByExample(example);
            if(usersExist == null || usersExist.size() <= 0) {
                usersNotExist.add(username);
            }
        }

        if(usersNotExist.size() >= 1){
            throw new BusinessException(ResponseStatus.Invalid.getCode(), "usernames:" + usersNotExist.toString() + " doesn't exist");
        }

        UserExample example = new UserExample();
        example.createCriteria().andUsernameIn(usernameList);
        int row = userRepository.deleteByExample(example);
        DeleteUsersResponse deleteUsersResponse = new DeleteUsersResponse();
        if(row > 0 && row == usernameList.size()){
            deleteUsersResponse.setRow(row);
            deleteUsersResponse.setStatus(true);
        }else{
            deleteUsersResponse.setRow(row);
            deleteUsersResponse.setStatus(false);
        }
        return deleteUsersResponse;
    }
}