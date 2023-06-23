package com.example.ung_dung_blog.model.repository;

import com.example.ung_dung_blog.model.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
