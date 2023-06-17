package com.example.demo4;

import com.example.demo4.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentControler {
    @Autowired
    ICondimentService condimentService;

    @RequestMapping("")
    public String save() {
        return "index";
    }

    @RequestMapping("/save")
    public String saveCondiment(@RequestParam("condiment") String[] condiment, Model model) {
        String result = condimentService.saveCondiment(condiment);
        model.addAttribute("result", result);
        return "index";
    }
}
