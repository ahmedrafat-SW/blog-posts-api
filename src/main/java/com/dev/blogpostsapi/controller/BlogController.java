package com.dev.blogpostsapi.controller;

import com.dev.blogpostsapi.model.BlogDTO;
import com.dev.blogpostsapi.data.entity.Author;
import com.dev.blogpostsapi.data.entity.Blog;
import com.dev.blogpostsapi.data.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/blogs")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    @Autowired
    private BlogRepository repository;

    @GetMapping
    public List<BlogDTO> getAllBlogs(){
        return repository.findAll()
                .stream()
                .map(this::abstractBlog).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getBlogById(@Validated @PathVariable Long id){
        if(repository.existsById(id)){
            Blog blog = repository.findById(id).get();
            Author author = blog.getAuthor();
            BlogDTO blogDTO = new BlogDTO(blog,author);
            return ResponseEntity.ok(blogDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(id+" Not found. Please enter an existing Id.");
        }

    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog){
        return repository.save(blog);
    }

    @PutMapping(path = "edit/{id}")
    public Optional<Blog> updateBlogContent(@PathVariable Long id, @RequestBody Blog blog){
        repository.findById(id).ifPresent(b ->
                {
                    b.setBlogTitle(blog.getBlogTitle());
                    b.setBlogBody(blog.getBlogBody());
                    b.setPublishDate(blog.getPublishDate());
                });
        return repository.findById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteBlog(@PathVariable Long id){
        Optional<Blog> blog = repository.findById(id);
        repository.delete(blog.get());
    }

    private  BlogDTO abstractBlog(Blog blog){
        return new BlogDTO(
//                blog.getBlogId(),
                blog.getBlogTitle(),
                blog.getAuthor().getFirstName() + " "+
                        blog.getAuthor().getLastName(),
                blog.getBlogBody(),
                blog.getPublishDate()
        );
    }
}
