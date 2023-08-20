package com.dev.blogpostsapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "blogs")
@Data
public class Blog {
    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;

    @Column(name = "blog_title", columnDefinition = "text")
    private String blogTitle;

    @Column(name = "blog_body", columnDefinition = "text")
    private String blogBody;

    @Column(name = "publish_date")
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Blog() {}

    public Blog(int blogId, String blogTitle, Author author, Date publishDate, String blogBody) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.author = author;
        this.publishDate = publishDate;
        this.blogBody = blogBody;
    }
}

