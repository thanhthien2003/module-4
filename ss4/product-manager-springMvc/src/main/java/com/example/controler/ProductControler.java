package com.example.controler;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductControler {
    @Autowired
    IProductService productService;

    @RequestMapping("")
    public String getListProduct(Model model) {
        model.addAttribute("productList", productService.display());
        return "/list";
    }

    @GetMapping("/product/{id}")
    public String findProductByName(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getDetailProduct(id));
        return "/detail";
    }

    @GetMapping("/showFormEdit")
    public String showFormEdit(@RequestParam("idEdit") int id, Model model) {
        for (Product p:productService.display()) {
            if (p.getId()==id){
                model.addAttribute("product",p);
                break;
            }
        }
    return "/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        if (productService.edit(product)){
            redirectAttributes.addFlashAttribute("msg","Edit done");
        } else {
            redirectAttributes.addFlashAttribute("msg","Can't not Edit");
        }
        return "redirect:/";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        if (productService.create(product)){
            redirectAttributes.addFlashAttribute("msg","Create done");
        } else {
            redirectAttributes.addFlashAttribute("msg","Can't not create,The id exist");
        }
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") int id,RedirectAttributes redirectAttributes){
        if (productService.delete(id)){
            redirectAttributes.addFlashAttribute("msg","Delete done");
        } else {
            redirectAttributes.addFlashAttribute("msg","Can't not delete");
        }
        return "redirect:/";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("search") String name,Model model){
        model.addAttribute("productList",productService.findByName(name));
        return "/list";
    }
}
