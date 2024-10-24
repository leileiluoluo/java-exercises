package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    List<Blog> listAllBlogs();

    Optional<Blog> getBlogById(Long id);

}
