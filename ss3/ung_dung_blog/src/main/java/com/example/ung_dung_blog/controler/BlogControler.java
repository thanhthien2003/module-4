package com.example.ung_dung_blog.controler;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogControler {
    @Autowired
    IBlogService blogService;
    @GetMapping("")
    public String getList(Model model){
        model.addAttribute("blogList",blogService.displayBlog());
        return "list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("msg","Create success");
        return "redirect:/blog";
    }
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.detailBlog(id));
            return "update";
        }
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        blogService.editBlog(blog);
        redirectAttributes.addFlashAttribute("msg","Edit success");
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Integer id,Model model,RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/blog";
        }else {
            model.addAttribute("blog",blogService.detailBlog(id));
            return "delete";
        }
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        blogService.deleteBlog(blog);
        redirectAttributes.addFlashAttribute("msg","delete success");
        return "redirect:/blog";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/";
        } else {
            model.addAttribute("blogList", blogService.detailBlog(id));
            return "detail";
        }
    }
}
