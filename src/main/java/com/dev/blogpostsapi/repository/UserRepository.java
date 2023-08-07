package com.dev.blogpostsapi.repository;

import com.dev.blogpostsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
