package com.dev.blogpostsapi.data.repository;

import com.dev.blogpostsapi.data.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findByBlogTitle(String title);
}
