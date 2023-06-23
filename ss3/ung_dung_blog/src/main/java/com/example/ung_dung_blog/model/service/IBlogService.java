package com.example.ung_dung_blog.model.service;

import com.example.ung_dung_blog.model.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> displayBlog();
    void createBlog(Blog blog);
    void editBlog(Blog blog);
    Blog detailBlog(Integer id);
    boolean deleteBlog(Blog blog);

}
