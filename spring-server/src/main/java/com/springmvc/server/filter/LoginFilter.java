package com.springmvc.server.filter;

import com.springmvc.server.utils.BeanHelper;
import com.springmvc.server.utils.LoginCkService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.lang.StringUtils;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongbanglong on 2017/5/11.
 */
public class LoginFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoginFilter.class);
    private List<String> whiteUrls = new ArrayList<String>();
    private LoginCkService loginCkService;


    private void loadConfiguration(FilterConfig config) {
        String whiteUrlsString = config.getInitParameter("whiteUrls");
        if(StringUtils.isNotEmpty(whiteUrlsString)) {
            String[] strs = whiteUrlsString.split(",");
            for (String str : strs) {
                str = str.trim();
                if(str.length() > 0) {
                    this.whiteUrls.add(str);
                }
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if(this.loginCkService == null){
            loginCkService = (LoginCkService)BeanHelper.getBean("loginCkService");
        }
        this.loadConfiguration(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String uri = req.getRequestURI();

//        if(!loginCkService.isLogin(req)){
//            resp.sendRedirect("/loginerror");
//            return;
//        }

        if(this.whiteUrls.size() >= 1){
            for(String whiteUrl : whiteUrls){
                if(uri.endsWith(whiteUrl)){
                    filterChain.doFilter(req, resp);
                    return;
                }
            }
        }

        if(!uri.endsWith("loginerror")){
            resp.sendRedirect("/loginerror");
            return;
        }

        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
