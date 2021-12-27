package com.github.miller.shan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: SpringMVC 配置，用于扩展SpringBoot对Spring MVC 的支持，而且会保留SpringBoot对SpringMVC的默认自动装配
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(MyMvcConfig.class);

    /**
     * 当访问/请求的时候，转到login。SpringBoot会默认拼接路径templates/ + login + .html.
     * 注意：如果使用thymeleaf模板引擎的时候则不能引入webjars的依赖，否则会找不到模板
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        logger.info("添加视图解析器");
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/index.html").setViewName("login");
//        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
         * /**:拦截任意层级下的任意请求
         * excludePathPatterns: 排除的请求
         * SpringBoot已经做好了静态资源映射所以不需要配置*.js、*.css
         */
        // 需要排除拦截的请求列表
        List<String> patterns = new ArrayList<>();
        patterns.add("/index.html");
        patterns.add("/");
        patterns.add("/user/login");
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(patterns);

        logger.info("添加拦截器{}", registry);
    }

}
