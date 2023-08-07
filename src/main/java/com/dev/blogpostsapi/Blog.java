package com.dev.blogpostsapi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "blogs")
@Setter
@Getter
public class Blog {
    @Id
    @Column(name = "blog_id")
    private int blogId;

    @Column(name = "blog_title")
    private String blogTitle;

    @ManyToOne
    @JoinColumn(name = "blog_author_id")
    private Author author;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "blog_body")
    private String blogBody;

    public Blog() {
    }

    public Blog(int blogId, String blogTitle, Author author, Date publishDate, String blogBody) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.author = author;
        this.publishDate = publishDate;
        this.blogBody = blogBody;
    }
    // Getters and setters
}

