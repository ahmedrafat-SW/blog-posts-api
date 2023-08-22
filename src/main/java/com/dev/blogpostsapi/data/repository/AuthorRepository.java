package com.dev.blogpostsapi.data.repository;

import com.dev.blogpostsapi.data.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByFirstName(String firstName);
}
