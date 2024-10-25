package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/add-form")
    public String addBlogForm(Blog blog) {
        return "blogs/add";
    }

    @PostMapping("")
    public String addBlog(Blog blog, Errors errors) {
        // validation
        if (StringUtils.isBlank(blog.getName())) {
            errors.rejectValue("name", "fields.invalid", "名称不能为空");
            return "blogs/add";
        }
        if (StringUtils.isBlank(blog.getDescription())) {
            errors.rejectValue("description", "fields.invalid", "描述不能为空");
            return "blogs/add";
        }

        // add blog
        blogService.addBlog(blog);

        return "redirect:/blogs";
    }

    @GetMapping("")
    public String listAllBlogs(Model model) {
        List<Blog> allBlogs = blogService.listAllBlogs();

        model.addAttribute("blogs", allBlogs);

        return "blogs/blogs";
    }

    @GetMapping("/{id}")
    public String getBlogById(@PathVariable("id") Integer id, Model model) {
        Optional<Blog> optional = blogService.getBlogById(id);
        if (optional.isEmpty()) {
            return "error/404";
        }

        model.addAttribute("blog", optional.get());

        return "blogs/blog";
    }

}
