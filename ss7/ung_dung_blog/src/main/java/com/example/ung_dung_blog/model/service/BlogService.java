package com.example.ung_dung_blog.model.service;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> displayBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog detailBlog(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean deleteBlog(Blog blog) {
        blogRepository.delete(blog);
        return true;
    }
}
