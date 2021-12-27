package com.github.miller.shan.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 数据源配置类
 **/
@Configuration
public class DruidConfig {

    /**
     * 将我们自己的数据源注册进。并绑定spring.datasource属性
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid监控。http://localhost:8080/druid
     * 1：配置一个管理后台的Servlet，用于处理所有Druid请求
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, Object> initParams = new HashMap<>();
        initParams.put("loginUserName", "admin");
        initParams.put("loginPassWord", "123456");
        //默认允许所有访问
        initParams.put("allow", "");
        // 拒绝这个ip进行访问
        initParams.put("deny", "192.168.0.1");

        bean.setInitParameters(initParams);

        return bean;
    }

    /**
     * 2：配置web监控的请求过滤器
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, Object> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        filterRegistrationBean.setInitParameters(initParams);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }


}
