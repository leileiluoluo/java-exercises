package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String listAllBlogs(Model model) {
        List<Blog> allBlogs = blogService.listAllBlogs();

        model.addAttribute("blogs", allBlogs);

        return "blogs/blogs";
    }

    @GetMapping("/{id}")
    public String getBlogById(@PathVariable("id") Long id, Model model) {
        Optional<Blog> optional = blogService.getBlogById(id);

        model.addAttribute("blog", optional.get());

        return "blogs/blog";
    }

}
