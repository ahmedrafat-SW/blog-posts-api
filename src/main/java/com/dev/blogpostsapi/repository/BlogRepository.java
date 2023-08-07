package com.dev.blogpostsapi.repository;

import com.dev.blogpostsapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
