package com.springmvc.server.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiongbanglong on 2017/5/11.
 */

@Controller
public class LoginErrorController {

    private static final Logger logger = LogManager.getLogger(LoginErrorController.class);

    @RequestMapping(value = "/loginerror")
    @ResponseBody
    public String put(HttpServletRequest request, HttpServletResponse response) {
        logger.error("Please login at first!");
        return "Please login at first!";
    }
}
