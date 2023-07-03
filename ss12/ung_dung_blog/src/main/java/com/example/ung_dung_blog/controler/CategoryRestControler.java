package com.example.ung_dung_blog.controler;

import com.example.ung_dung_blog.model.model.Category;
import com.example.ung_dung_blog.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestControler {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public List<Category> getList() {
        return  this.categoryService.displayCategory();
    }
}
