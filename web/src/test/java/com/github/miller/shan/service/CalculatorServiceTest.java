package com.github.miller.shan.service;

import com.github.miller.shan.Calculator;
import com.github.miller.shan.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * @Project: jacocotest
 * @Author: Miller
 * @Time: 2021-05-19 14:25
 * @Email: miller.shan@aliyun.com
 * @Description:
 **/
public class CalculatorServiceTest {
    CalculatorService calculatorService = null;

    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach method invoked...");
        calculatorService = new CalculatorService();
    }

    @Test
    public void testAdd() {
        Calculator actual = calculatorService.add(2.0, 2.0);
        Assertions.assertEquals(4, actual.getResult());
    }

    @Disabled
    @Test
    public void testSubtract() {
        Calculator actual = calculatorService.subtract(2.0, 2.0);
        Assertions.assertEquals(0, actual.getResult());
    }

    @Disabled
    @Test
    public void testMultiply() {
        Calculator actual = calculatorService.multiply(2.0, 2.0);
        Assertions.assertEquals(4, actual.getResult());
    }

    @Test
    public void testDivision() {
        Calculator actual = calculatorService.division(2.0, 2.0);
        Assertions.assertEquals(1, actual.getResult());
    }

    @Test
    public void testDivisionIsZero() {
        //2：如果抛出的异常与设定的异常相同，则这一步的断言成功并返回一个异常的顶级父类
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            //1：执行此语句会抛出一个ArithmeticException异常，被assertThrows方法捕获
            calculatorService.division(2.0, 0.0);
        });

        Assertions.assertEquals("division by zero", exception.getMessage());
    }
}
