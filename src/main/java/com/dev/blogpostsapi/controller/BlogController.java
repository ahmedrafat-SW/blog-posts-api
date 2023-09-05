package com.dev.blogpostsapi.controller;

import com.dev.blogpostsapi.model.BlogDTO;
import com.dev.blogpostsapi.data.entity.Blog;
import com.dev.blogpostsapi.data.repository.BlogRepository;
import com.dev.blogpostsapi.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BlogDTO> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @GetMapping(path = "/{id}")
    public BlogDTO getBlogById(@Validated @PathVariable int id){
       return blogService.getBlogById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogDTO createBlog(@RequestBody BlogDTO blog){
        return blogService.createBlog(blog);
    }

    @PutMapping(path = "edit/{id}")
    public BlogDTO updateBlogContent(@PathVariable int id, @RequestBody BlogDTO blog){
        return blogService.updateBlog(blog);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteBlog(@PathVariable int id){
        blogService.deleteBlog(id);
    }

}
