package com.dev.blogpostsapi.repositorytest;

import com.dev.blogpostsapi.model.Blog;
import com.dev.blogpostsapi.repository.BlogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void testFindBlogById(){
        Blog blog = blogRepository.findById(1L).get();
        Assertions.assertEquals(blog.getBlogTitle(), "How to execute .sql file in PostgreSQL");
    }
}
