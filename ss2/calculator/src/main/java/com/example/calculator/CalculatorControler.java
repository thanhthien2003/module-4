package com.example.calculator;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorControler {
    @Autowired
    private ICalculatorService calculatorService;

    @RequestMapping
    public String calculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("number1") Double number1, @RequestParam("number2") Double number2,
                             @RequestParam("calculate") String calculate, Model model) {
        if (number1 == null || number2 == null || calculate == ""){
            return "index";
        }
        if (number2 == 0 & calculate.equals("divi")){
            String resultEror = "Cannot divide by zero number";
            model.addAttribute("result",resultEror);
            return "index";
        }
        double result = calculatorService.calculate(number1,number2,calculate);
        model.addAttribute("result",result);
        return "index";
    }
}
