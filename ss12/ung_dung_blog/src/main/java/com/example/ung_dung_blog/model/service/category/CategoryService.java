package com.example.ung_dung_blog.model.service.category;

import com.example.ung_dung_blog.model.model.Category;
import com.example.ung_dung_blog.model.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> displayCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void editCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean deleteCategory(Category category) {
        categoryRepository.delete(category);
        return true;
    }

    @Override
    public Category detailCategory(Integer id) {
        return categoryRepository.findById(id).get();
    }
}