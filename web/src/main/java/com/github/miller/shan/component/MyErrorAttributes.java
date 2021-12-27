package com.github.miller.shan.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

/**
 * @Description: 自定义错误处理。保留了SprintBoot的默认错误处理机制，然后添加自己的错误处理机制。
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 模拟出错，访问 /errorUser?user=aaa 请求的时候故意报错
     * 在PostMan中访问会返回json数据：http://localhost:8080/errorUser?user=aaa
     * 在浏览器中访问会自动跳转到错误页面：http://localhost:8080/errorUser
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> resultMap = super.getErrorAttributes(webRequest, includeStackTrace);
        resultMap.put("company", "Miller");

        // 添加上我们自己的异常处理控制器携带的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", SCOPE_REQUEST);
        resultMap.put("ext", ext);

        return resultMap;
    }
}
