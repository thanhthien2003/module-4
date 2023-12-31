package com.example.ung_dung_blog.model.service.blog;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
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
        blogRepository.isDelete(blog.getId());
        return true;
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return blogRepository.findByTitle(title);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
    @Override
    public List<Blog> findBlogByCategory(int categoryId) {
        List<Blog>blogs= new ArrayList<>();
        for (Blog b:findAll()) {
         if (categoryId==b.getCategory().getId()){
             blogs.add(b);
         }
        }
        return blogs;
    }

    @Override
    public List<Blog> findBlogByName(String name) {
        return blogRepository.findByName(name);
    }
}
