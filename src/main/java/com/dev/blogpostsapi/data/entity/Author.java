package com.dev.blogpostsapi.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "author_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "bio", columnDefinition = "text")
    private String bio;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "phone")
    private String phone;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs = new ArrayList<>();


    public Author() {}

    public Author(Long id, String firstName, String lastName, String bio, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.email = email;
        this.password = password;
    }

    public Author(Long id, String firstName, String lastName, String bio, String jobTitle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.jobTitle = jobTitle;
    }
}
