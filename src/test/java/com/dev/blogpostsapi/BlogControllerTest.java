package com.dev.blogpostsapi;


import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BlogControllerTest {

    private Blog blog;
    private Author author;
    private BlogController blogController;
    @BeforeAll
   void init(){
//        author = new Author();
//        author.setFirstName("mo salah");
//        author.setRole(Role.AUTHOR);
////        blog = new Blog(1L, "Spring Boot and JPA ", "We are trying to test spring boot and spring data jpa using spring test project",author, LocalDate.now());
//        Assertions.assertEquals("mo salah", blog.getAuthor().getFirstName());
//        blogController = new BlogController();
    }
    @Test
    @DisplayName("Testing Spring Boot")
    public void createBlogTest(){
        Assertions.assertEquals("mo salah", blog.getAuthor().getFirstName());
    }

    @Test
    public void findBlogByIdTest(){
//        Blog b = blogController.getBlogById(1L).get();
//        Assertions.assertEquals(b.getAuthor().getFirstName(), blog.getAuthor().getFirstName());
//        Assertions.assertEquals(b.getTitle(), blog.getTitle());
//        System.out.println(b.getAuthor().getFirstName());
//        System.out.println(blog.getTitle());

    }
}
