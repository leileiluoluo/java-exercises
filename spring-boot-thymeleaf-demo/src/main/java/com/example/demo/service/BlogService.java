package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    void addBlog(Blog blog);

    List<Blog> listAllBlogs();

    Optional<Blog> getBlogById(Integer id);

}
