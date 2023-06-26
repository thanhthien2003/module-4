package com.example.bai_1.controler;

import com.example.bai_1.dto.UserDto;
import com.example.bai_1.model.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControler {
    @GetMapping("")
    public String showFormCreate(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "create";
        }
        User user  = new User();
        BeanUtils.copyProperties(userDto,user);
        model.addAttribute("user",user);
        return "display";
    }
}
