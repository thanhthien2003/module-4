package com.example.ung_dung_blog.controler;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.model.Category;
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
@RequestMapping("/category")
public class CategoryControler {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getList(Model model) {
        model.addAttribute("categoryList", categoryService.displayCategory());
        return "listCategory";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "createCategory";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.createCategory(category);
        redirectAttributes.addFlashAttribute("msg", "Create success");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String detail(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        if (categoryService.detailCategory(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/category";
        } else {
            categoryService.deleteCategory(categoryService.detailCategory(id));
            redirectAttributes.addFlashAttribute("msg", "delete success");
            return "redirect:/category";
        }
    }
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.detailCategory(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/blog";
        } else {
            model.addAttribute("category", categoryService.detailCategory(id));
            return "updateCategory";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.editCategory(category);
        redirectAttributes.addFlashAttribute("msg", "Edit success");
        return "redirect:/category";
    }
}
