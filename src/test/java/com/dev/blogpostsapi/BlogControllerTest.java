package com.dev.blogpostsapi;


import com.dev.blogpostsapi.controller.AuthorController;
import com.dev.blogpostsapi.controller.BlogController;
import com.dev.blogpostsapi.model.Author;
import com.dev.blogpostsapi.model.Blog;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BlogControllerTest {
    @Test
    public void findAuthorByIdTest(){
    }

    @Test
    @DisplayName("Testing Spring Boot")
    public void createBlogTest(){

    }
}
