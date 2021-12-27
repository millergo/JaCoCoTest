package com.github.miller.shan.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyListener implements ServletContextListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("服务器启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("服务器关闭了");
    }
}
