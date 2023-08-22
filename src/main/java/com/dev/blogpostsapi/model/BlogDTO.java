package com.dev.blogpostsapi.model;

import com.dev.blogpostsapi.data.entity.Author;
import com.dev.blogpostsapi.data.entity.Blog;
import lombok.Data;
import lombok.Setter;

import java.sql.Date;


@Data
public class BlogDTO {
    private int id;
    private Long authorId;
    private String title;
    private String body;
    private String authorName;
    private Date publishDate;

    public BlogDTO() {
    }

    public BlogDTO(int id, String title, String body,  Date publishDate,Long authorId , String authorName) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.publishDate = publishDate;
        this.authorName = authorName;
        this.authorId = authorId;
    }
}
