package com.example.ung_dung_blog.controler;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogRestControler {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public List<Blog> getListBlog(){
        return this.blogService.findAll();
    }
    @GetMapping("/{id}")
    public Blog detail(@PathVariable Integer id) {
        if (blogService.detailBlog(id)==null){
            throw new RuntimeException("id not found");
        }
            return this.blogService.detailBlog(id);
    }
    @GetMapping("/find/{id}")
    public List<Blog> getListByCategory(@PathVariable int id) {
        if (blogService.findBlogByCategory(id) == null) {
            throw new RuntimeException("id not found");
        }
        return blogService.findBlogByCategory(id);
    }
}
