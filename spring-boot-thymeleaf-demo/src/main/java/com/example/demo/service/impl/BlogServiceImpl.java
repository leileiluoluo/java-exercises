package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private static final List<Blog> ALL_BLOGS = List.of(
            new Blog(1L, "闫浩然的博客", "关注人文、地理、历史，环境朋友们来访问！", false, false),
            new Blog(2L, "刘昂西的博客", "Always fine! Always fun!", true, false),
            new Blog(3L, "宋心亮的博客", "生活就是一场相遇，遇见自己、遇见你！", false, false),
            new Blog(4L, "陈方圆的博客", "让我们荡起双桨，小船儿推开波浪！", false, true)
    );

    @Override
    public List<Blog> listAllBlogs() {
        return ALL_BLOGS;
    }

    @Override
    public Optional<Blog> getBlogById(Long id) {
        return ALL_BLOGS.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst();
    }

}
