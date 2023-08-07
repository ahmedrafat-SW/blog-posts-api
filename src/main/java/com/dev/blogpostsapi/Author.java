package com.dev.blogpostsapi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "author_id")
public class Author extends User {
    @Column(name = "bio")
    private String bio;

    public Author() {}

    public Author(int userId, String firstName, String lastName, String email, String password, String role, String bio) {
        super(userId, firstName, lastName, email, password, role);
        this.bio = bio;
    }
}
