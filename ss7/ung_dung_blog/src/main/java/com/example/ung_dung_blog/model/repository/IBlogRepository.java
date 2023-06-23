package com.example.ung_dung_blog.model.repository;

import com.example.ung_dung_blog.model.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
