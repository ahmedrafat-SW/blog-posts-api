package com.dev.blogpostsapi.model;

import com.dev.blogpostsapi.data.entity.Author;
import com.dev.blogpostsapi.data.entity.Blog;
import lombok.Setter;

import java.sql.Date;


@Setter
public class BlogDTO {

    private Blog blog;
    private Author author;
    private int id;
    private String title;
    private String body;
    private String authorName;
    private Date publishDate;

    public BlogDTO() {
    }

    public BlogDTO(Blog blog, Author author) {
        this.blog = blog;
        this.author = author;
    }

    public BlogDTO( String title, String body, String authorName, Date publishDate) {
//        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public int getId(){
        id = blog.getBlogId();
        return id;
    }

    public String getTitle(){
        title = blog.getBlogTitle();
        return title;
    }

    public String getBody(){
        body = blog.getBlogBody();
        return body;
    }

    public String getAuthorName(){
        authorName = author.getFirstName() +" "+ author.getLastName();
        return authorName;
    }

    public Date getPublishDate(){
        publishDate = blog.getPublishDate();
        return publishDate;
    }


}
