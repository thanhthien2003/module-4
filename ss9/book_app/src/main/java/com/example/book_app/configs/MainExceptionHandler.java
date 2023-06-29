package com.example.book_app.configs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler extends Exception{
    @ExceptionHandler
    public String getErrorCurrentlyBook(Exception ex, Model model) {
        String msg = "This book is currently out of stock";
        model.addAttribute("msg", msg);
        return "/500";
    }
}
