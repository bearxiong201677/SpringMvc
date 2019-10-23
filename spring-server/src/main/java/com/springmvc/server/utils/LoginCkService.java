package com.springmvc.server.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiongbanglong on 2017/5/11.
 */

@Service("loginCkService")
public class LoginCkService {
    private static final Logger logger = LogManager.getLogger(LoginCkService.class);

    public Boolean isLogin(HttpServletRequest request){
        if(getCookieVaule(request,"pin").equalsIgnoreCase("jcloud_00")){
            return true;
        }
        return false;
    }

    protected String getCookieVaule(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        String cookieValue = null;
        if(cookies.length >= 1){
            logger.info("读取Cookies...");
            for(Cookie cookie : cookies){
                logger.info("[" + cookie.getName() + "-->" + cookie.getValue() + "]" );
                if(cookie.getName().equalsIgnoreCase(cookieName)){
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
