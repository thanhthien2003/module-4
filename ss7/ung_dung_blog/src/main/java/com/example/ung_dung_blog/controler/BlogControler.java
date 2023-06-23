package com.example.ung_dung_blog.controler;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.service.blog.IBlogService;
import com.example.ung_dung_blog.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogControler {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getList(@PageableDefault(size = 2, sort = "dateSubmitted", direction = Sort.Direction.ASC)
                          Pageable pageable, Model model) {
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        model.addAttribute("categorys", categoryService.displayCategory());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "Create success");
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.detailBlog(id));
            return "update";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.editBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "Edit success");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.detailBlog(id));
            return "delete";
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "delete success");
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

    @GetMapping("/search")
    private String search(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC)
                          Pageable pageable, Model model, @RequestParam("title") String title) {
        model.addAttribute("blogList", blogService.findByTitle(pageable, title));
        return "list";
    }
}
