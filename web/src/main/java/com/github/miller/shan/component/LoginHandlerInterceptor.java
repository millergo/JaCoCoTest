package com.github.miller.shan.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 登录拦截器，拦截所有请求
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

    /**
     * 目标方法执行之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
          OPS伪登录代码
         */
        String token = request.getHeader("Cookie");
        // 调用OPS接口用于判断token是否生效，并且通过token获取用户信息
        if (!StringUtils.isEmpty(token)) {
//            logger.info("token有效:{}", token);
            // return true 可以继续请求接口测试模块请求
        }

        Object user = request.getSession().getAttribute("loginUser");
        if (null == user) {
            logger.info("未登录{}", user);
            //未登录
            request.setAttribute("msg", "没有权限，请先登录");
            // 请求转发到新地址。在一个请求中完成。
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 已登录
            logger.info("已登录:{}", user);
            return true;
        }
    }

}
