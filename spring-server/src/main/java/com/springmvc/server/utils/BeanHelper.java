package com.springmvc.server.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by xiongbanglong on 2017/5/11.
 */
public class BeanHelper {
    public static WebApplicationContext wac = null;
    private static final Logger logger = LogManager.getLogger(BeanHelper.class);

    public static Object getBean(String name) {
        Object obj = null;
        try {
            WebApplicationContext wac = appCtx();
            obj = wac.getBean(name);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return obj;
    }

    public static WebApplicationContext appCtx() {
        if (wac==null) {
            wac = ContextLoader.getCurrentWebApplicationContext();
        }
        return wac;
    }
}
