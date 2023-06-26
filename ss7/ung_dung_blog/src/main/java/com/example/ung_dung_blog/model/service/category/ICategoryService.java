package com.example.ung_dung_blog.model.service.category;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> displayCategory();
    void createCategory(Category category);
    void editCategory(Category category);
    boolean deleteCategory(Category category);
    Category detailCategory(Integer id);
}
