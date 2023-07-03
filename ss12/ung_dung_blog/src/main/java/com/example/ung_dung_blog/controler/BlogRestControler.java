package com.example.ung_dung_blog.controler;

import com.example.ung_dung_blog.model.model.Blog;
import com.example.ung_dung_blog.model.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogRestControler {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getListBlog() {
        return new ResponseEntity<>(this.blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> detail(@PathVariable Integer id) {
        Blog blog = blogService.detailBlog(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @PostMapping("/category/{id}")
    public ResponseEntity<List<Blog>> getListByCategory(@PathVariable int id) {
        if (blogService.findBlogByCategory(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogService.findBlogByCategory(id), HttpStatus.OK);
        }
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> findBlogByTitle(@PathVariable String title) {
        List<Blog> blogList = blogService.findByTitle(title);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
