package com.example.ung_dung_gio_hang.controler;

import com.example.ung_dung_gio_hang.model.Cart;
import com.example.ung_dung_gio_hang.model.Product;
import com.example.ung_dung_gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductControler {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getList(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "list";
    }

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/cart")
    public String getCartFromSession(@SessionAttribute("cart") Cart cart,
                                     Model model) {
        model.addAttribute("listCart", cart.getProducts());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product==null){
            redirectAttributes.addFlashAttribute("msg","id not found");
            return "redirect:/";
        }
        if (action.equals("addProduct")) {
            cart.addProduct(product);
            return "redirect:/";
        }
        if (action.equals("sum")) {
            cart.addProduct(product);
            return "redirect:/cart";
        }
        cart.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action,Model model) {
        Product product = productService.findById(id);
        if (product==null){
            model.addAttribute("msg","id not found");
            return "list";
        }
        if (action.equals("sub")) {
            cart.removeProduct(product);
            return "redirect:/cart";
        }
        return "redirect:/cart";
    }
    @GetMapping("/pay")
    public String pay(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes){
        cart.payment();
        redirectAttributes.addFlashAttribute("msg", "Pay Success.");
        return "redirect:/";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        if (product==null){
            model.addAttribute("msg","id not found");
            return "redirect:/";
        }
        model.addAttribute("product", product);
        return "/detail";
    }
}
