package com.github.miller.shan;

import com.github.miller.shan.controller.CalculatorController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTest {

    @Autowired
    CalculatorController calculatorController;

    @Disabled("junit 5")
    @Test
    void contextLoads() {
        System.out.println("Disabled invoked");
    }

    @Test
    public void testUseJunit5()
    {
        System.out.println("junit 5...");
    }

    @Test
    public void testAdd() {
        calculatorController.add(2.0, 2.0);
    }
    @Test
    public void testSubtract() {
        calculatorController.subtract(2.0, 2.0);
    }

}
