package com.github.miller.shan.cucumber;

import com.github.miller.shan.WebApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Project: jacocotest
 * @Author: Miller
 * @Time: 2021-07-19 14:24
 * @Email: miller.shan@aliyun.com
 * @Description:
 **/
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
@CucumberContextConfiguration
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberTest {
}
