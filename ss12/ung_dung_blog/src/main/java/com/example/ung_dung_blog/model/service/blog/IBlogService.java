package com.example.ung_dung_blog.model.service.blog;

import com.example.ung_dung_blog.model.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void createBlog(Blog blog);
    void editBlog(Blog blog);
    Blog detailBlog(Integer id);
    boolean deleteBlog(Blog blog);
    List<Blog> findByTitle(String title);
    List<Blog> findAll();
   List<Blog> findBlogByCategory(int categoryId);
   List<Blog> findBlogByName(String name);
}
