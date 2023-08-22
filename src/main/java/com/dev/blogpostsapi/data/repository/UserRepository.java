package com.dev.blogpostsapi.data.repository;

import com.dev.blogpostsapi.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
