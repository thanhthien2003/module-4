package com.example.chuyen_doi_tien_te.controler;

import com.example.chuyen_doi_tien_te.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorControler {
    @Autowired
    private ICalculatorService calculatorService;
    @PostMapping ("/calculator")
        public String calculator(@RequestParam("usd") double money , @RequestParam("exchange") double exchange, Model model){
                model.addAttribute("result",calculatorService.calculate(money,exchange));
                return "result";
        }
}
