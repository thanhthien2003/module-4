package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public double calculate(double number1, double number2, String calculate) {
        double number = 0;
        switch (calculate) {
            case "add":
                number = number1 + number2;
                break;
            case "sub":
                number = number1 - number2;
                break;
            case "mutip":
                number = number1 * number2;
                break;
            case "divi":
                number = number1/number2;
        }
        return number;
    }
    }
