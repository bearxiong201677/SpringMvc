package com.springmvc.server.controller;

import com.springmvc.api.exception.BusinessException;
import com.springmvc.api.model.Response;
import com.springmvc.api.model.UserVo;
import com.springmvc.api.model.v1.CreateUsersRequest;
import com.springmvc.api.model.v1.ErrorResponse;
import com.springmvc.api.model.v1.QueryUsersRequest;
import com.springmvc.api.model.v1.DeleteUsersRequest;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.lang.Integer;
import java.util.*;
import com.springmvc.api.model.ResponseStatus;


/**
 * Created by xiongbanglong on 2017/4/17.
 */

/**
 * @Controller   注解类型的适配器
 * @RequestMapping  注解类型的映射器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUsers",method = RequestMethod.POST)
    @ResponseBody
    public Response batchCreateUsers(@RequestBody CreateUsersRequest request){
        if (request.getRequestId() == null) {
            request.setRequestId(UUID.randomUUID().toString());
        }

        if(request.getUserList() == null || request.getUserList().size() <=0){
            return new ErrorResponse(ResponseStatus.Invalid.getCode(), "userList is null");
        }

        for(UserVo userVo : request.getUserList()){
            validateUserVo(userVo);
        }
        Response response = null;
        try{
            response = userService.batchCreateUsers(request.getUserList());
            response.setRequestId(request.getRequestId());
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        logger.info(response.toString());
        return response;
    }

    @RequestMapping(value = "/queryUsers",method = RequestMethod.POST)
    @ResponseBody
    public Response queryUsers(@RequestBody QueryUsersRequest request){
        if (request.getRequestId() == null) {
            request.setRequestId(UUID.randomUUID().toString());
        }

        logger.info(request.toString());

        if (request.getUserIds() == null || request.getUserIds().size() <= 0){
            return new ErrorResponse(ResponseStatus.Invalid.getCode(), "userIds is null");
        }

        List<Integer> userIds = request.getUserIds();
        Response response = null;
        try{
            response = userService.queryUsers(userIds);
            response.setRequestId(request.getRequestId());
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        logger.info(response.toString());
        return response;
    }


    @RequestMapping(value = "/deleteUsers",method = RequestMethod.POST)
    @ResponseBody
    public Response deleteUsers(@RequestBody DeleteUsersRequest request){
        if (request.getRequestId() == null) {
            request.setRequestId(UUID.randomUUID().toString());
        }

        logger.info(request.toString());

        if (request.getUsernameList() == null || request.getUsernameList().size() <= 0){
            return new ErrorResponse(ResponseStatus.Invalid.getCode(), "usernameList is null");
        }

        Response response = null;
        try{
            response = userService.batchDeleteUsers(request.getUsernameList());
            response.setRequestId(request.getRequestId());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.info(response.toString());
        return response;
    }

    private void validateUserVo(UserVo userVo) {
        String error = null;
        if(userVo == null){
            error = "Invalid userVo";
        }else if (userVo.getUsername() == null || userVo.getUsername().equals("")) {
            error = "Invalid username";
        }

        if (error != null) {
            throw new BusinessException(ResponseStatus.Invalid.getCode(), error);
        }
    }
}
