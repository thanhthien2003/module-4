package com.example.savemail.controler;

import com.example.savemail.model.model.Mail;
import com.example.savemail.model.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailControler {
    @Autowired
    IMailService mailService;

    @GetMapping("/displayList")
    public String display(Model model) {
        model.addAttribute("mailList", mailService.display());
        return "display";
    }

    @GetMapping("/showFormEdit")
    public String showFormEdit(@RequestParam("idEdit") int idEdit, Model model) {
        for (Mail m : mailService.display()) {
            if (idEdit == m.getId()) {
                model.addAttribute("mail", m);
                break;
            }
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes) {
        if (mailService.edit(mail)) {
            redirectAttributes.addFlashAttribute("msg", "Edit done");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Edit not working, you wrong something");
        }
        return "redirect:/displayList";
    }
}
