package com.github.miller.shan.service;

import com.github.miller.shan.Calculator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project: java
 * @Author: Miller
 * @Time: 2020-06-29 10:46
 * @Email: miller.shan@aliyun.com;miller.shan.dd@gmail.com
 * @Description: 计算器
 **/
@Data
@Service
public class CalculatorService {

    public Calculator add(Double firstNumber, Double secondNumber) {
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setResult(firstNumber + secondNumber);
        return calculator;
    }

    public Calculator subtract(Double firstNumber, Double secondNumber) {
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setResult(firstNumber - secondNumber);
        return calculator;
    }

    public Calculator multiply(Double firstNumber, Double secondNumber) {
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setResult(firstNumber * secondNumber);
        return calculator;
    }

    public Calculator division(Double firstNumber, Double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("division by zero");
        }
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setResult(firstNumber / secondNumber);
        return calculator;
    }
}