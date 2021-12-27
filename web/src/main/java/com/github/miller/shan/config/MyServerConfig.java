package com.github.miller.shan.config;

import com.github.miller.shan.filter.MyFilter;
import com.github.miller.shan.listener.MyListener;
import com.github.miller.shan.servlet.MyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.util.Arrays;

/**
 * @Description: 服务器相关配置
 **/
@Configuration
public class MyServerConfig {
    Logger logger = LoggerFactory.getLogger(MyServerConfig.class);

    /**
     * 注册Servlet三大组件
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        logger.info("向容器中注入Servlet.");

        /**
         * 参数1：处理拦截请求的Servlet
         * 参数2：拦截的路径。
         * 当发送/myServlet请求的时候就会被 MyServlet 处理
         */
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        logger.info("向容器中注入 Filter.");

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myFilter", "/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        logger.info("向容器中注入listener");
        ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }

    /**
     * 定制嵌入式的Servlet容器相关规则
     */
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

            @Override
            public void customize(ConfigurableWebServerFactory factory) {
//                factory.setPort(8085);
            }
        };
    }
}
