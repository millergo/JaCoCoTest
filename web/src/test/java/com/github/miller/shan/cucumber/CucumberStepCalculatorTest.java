package com.github.miller.shan.cucumber;

import com.github.miller.shan.Calculator;
import com.github.miller.shan.service.CalculatorService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * @Project: jacocotest
 * @Author: Miller
 * @Time: 2021-07-19 15:40
 * @Email: miller.shan@aliyun.com
 * @Description: calculator.feature
 **/
public class CucumberStepCalculatorTest extends CucumberTest {
    CalculatorService calculatorService = null;
    Calculator calculator = null;

    @Given("^假设给我两个整数 (\\d+), (\\d+)$")
    public void given(Double firstNumber, Double secondNumber) {
        calculator = new Calculator();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
    }

    @When("^当你运行测试时$")
    public void when() {
        calculatorService = new CalculatorService();
    }

    @Then("^我能计算两个数的和$")
    public void testAdd() {
        Calculator actual = calculatorService.add(calculator.getFirstNumber(), calculator.getSecondNumber());
        Assertions.assertEquals(30, actual.getResult());
    }

    @Then("^我能计算两个数的差$")
    public void testSubtract() {
        Calculator actual = calculatorService.subtract(calculator.getFirstNumber(), calculator.getSecondNumber());
        Assertions.assertEquals(10, actual.getResult());
    }

    @Then("^我能计算两个数的积$")
    public void testMultiply() {
        Calculator actual = calculatorService.multiply(calculator.getFirstNumber(), calculator.getSecondNumber());
        Assertions.assertEquals(200, actual.getResult());
    }

    @Then("^我能计算两个数的商$")
    public void testDivision() {
        Calculator actual = calculatorService.division(calculator.getFirstNumber(), calculator.getSecondNumber());
        Assertions.assertEquals(2, actual.getResult());
        // 下面这行代码时为了演示失败的情况
//        Assertions.assertEquals(301, actual.getResult());
    }
}
