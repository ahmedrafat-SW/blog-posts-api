package com.dev.blogpostsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/blogs")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    @Autowired
    private BlogRepository repository;

    @GetMapping
    public Iterable<Blog> getAllBlogs(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Blog> getBlogById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog){
        return repository.save(blog);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteBlog(@PathVariable Long id){
        Optional<Blog> blog = repository.findById(id);
        repository.delete(blog.get());
    }

}
