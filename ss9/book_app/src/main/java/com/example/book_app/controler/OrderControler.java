package com.example.book_app.controler;

import com.example.book_app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderControler {
    @Autowired
    private IOrderService orderService;
}
