package com.example.book_app.controler;

import com.example.book_app.model.Book;
import com.example.book_app.model.Order;
import com.example.book_app.service.IBookService;
import com.example.book_app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
public class BookControler {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;
    @GetMapping("")
    public String showList(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "/home";
    }
    @GetMapping("/borrow/{id}")
    public String showFormBorrow(@PathVariable Integer id, Model model){
        model.addAttribute("code",orderService.randomCode());
        model.addAttribute("idBook",id);
        return "borrow";
    }
    @PostMapping("/borrow")
    public String borrow(@RequestParam("code") int code, @RequestParam("idBook") Integer id, RedirectAttributes redirectAttributes){
        if (bookService.findById(id)==null){
            redirectAttributes.addFlashAttribute("msg","id not found");
        }
        Order order = new Order(code,bookService.findById(id));
        orderService.save(order);
        bookService.borrow(id);
        redirectAttributes.addFlashAttribute("msg","borrow done , don't forget give back book for me :3");
        return "redirect:/";
    }
    @GetMapping("/giveBack/{id}")
    public String showFormGiveBack(@PathVariable Integer id,Model model){
        model.addAttribute("idBook",id);
        return "giveBack";
    }
    @PostMapping("/giveBack")
    public String giveBack(@RequestParam("idBook") Integer idBook,@RequestParam("code") int code,RedirectAttributes redirectAttributes,Model model){
        if (orderService.findByCode(code)==null){
            model.addAttribute("msg","id not found");
            model.addAttribute("idBook",idBook);
            return "giveBack";
        }
        orderService.delete(orderService.findByCode(code));
        bookService.giveBack(idBook);
        redirectAttributes.addFlashAttribute("msg","Thanks bro");
        return "redirect:/";
    }
}
