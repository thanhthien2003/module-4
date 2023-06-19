package com.example.savemail.controler;

import com.example.savemail.model.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailControler {
    @Autowired
    IMailService mailService;
    @GetMapping("/displayList")
    public String display(Model model){
        model.addAttribute("mailList",mailService.display());
        return "display";
    }
}
