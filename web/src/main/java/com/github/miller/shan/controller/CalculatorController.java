package com.github.miller.shan.controller;

import com.github.miller.shan.Calculator;
import com.github.miller.shan.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.miller.shan.ResponseData;

@Slf4j
@RestController
@RequestMapping(value = "/api/cal")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping(value = "/add/{firstNumber}/{secondNumber}")
    public ResponseData add(@PathVariable Double firstNumber, @PathVariable Double secondNumber) {
        log.info("add method invoked...");
        if (firstNumber < 0) {
            return ResponseData.failed("firstNumber is < 0");
        }
        if (secondNumber < 0) {
            return ResponseData.failed("secondNumber is < 0");
        }
        Calculator result = calculatorService.add(firstNumber, secondNumber);
        return ResponseData.success(result);
    }

    @GetMapping(value = "/subtract/{firstNumber}/{secondNumber}")
    public ResponseData subtract(@PathVariable Double firstNumber, @PathVariable Double secondNumber) {
        log.info("subtract method invoked...");
        Calculator result = calculatorService.subtract(firstNumber, secondNumber);
        return ResponseData.success(result);
    }

    @GetMapping(value = "/multiply/{firstNumber}/{secondNumber}")
    public ResponseData multiply(@PathVariable Double firstNumber, @PathVariable Double secondNumber) {
        log.info("multiply method invoked...");
        Calculator result = calculatorService.multiply(firstNumber, secondNumber);
        return ResponseData.success(result);
    }

    @GetMapping(value = "/division/{firstNumber}/{secondNumber}")
    public ResponseData division(@PathVariable Double firstNumber, @PathVariable Double secondNumber) {
        log.info("division method invoked...");
        Calculator result = calculatorService.division(firstNumber, secondNumber);
        return ResponseData.success(result);
    }

    @GetMapping(value = "/diffTestOne/{firstNumber}/{secondNumber}")
    public ResponseData diffTestOne(@PathVariable Double firstNumber, @PathVariable Double secondNumber) {
        log.info("diffTestOne method invoked...");
        return ResponseData.success("diffTestOne method invoked...");
    }
    @GetMapping(value = "/diffTestTwo/{firstNumber}/{secondNumber}")
    public ResponseData diffTestTwo(@PathVariable Double firstNumber, @PathVariable Double secondNumber) {
        log.info("diffTestTwo method invoked...");
        return ResponseData.success("diffTestTwo method invoked...");
    }
}
