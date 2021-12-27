package com.github.miller.shan.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * @Project: jacocotest
 * @Author: Miller
 * @Time: 2021-07-19 14:25
 * @Email: miller.shan@aliyun.com
 * @Description: cucumber.feature
 **/
public class CucumberStepDefsTest extends CucumberTest {

    @Given("^假设客户端发送一个POST请求 /helloCucumber$")
    public void testSentPostRequest() {
        System.out.println("省略发送请求");
    }

    @When("^客户端发送一个GET请求 /cucumber$")
    public void testSentGetRequest() throws Throwable {
        System.out.println("省略发送请求");
    }

    @Then("^客户端收到响应状态码 (\\d+)$")
    public void theClientReceivedStatusCode(int code) {
        assertThat("200", containsString(Integer.toString(code)));
    }

    @And("^客户端接受到服务段返回的字符串 (.+)$")
    public void testClientReceivedString(String version) {
        assertThat("cucumber", is(version));
    }
}
