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
}
