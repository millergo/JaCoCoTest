package com.github.miller.shan.config;

import com.github.miller.shan.component.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**

 * @Description: Configuration注解：用于指明当前类是一个配置类，用于替代之前的Spring配置文件.
 * 与之前在SpringApplicationContext.xml文件中配置<bean></bean>是一样的效果。
 **/
@Configuration
public class MyAppConfig {
    Logger logger = LoggerFactory.getLogger(MyAppConfig.class);

    /**
     * 将方法的范围值添加到容器中，容器中这个组件的默认id就是方法名称
     */
    @Bean
    public MyService helloService() {
        logger.info("给容器中添加自己的组件");
        return new MyService();
    }

}
