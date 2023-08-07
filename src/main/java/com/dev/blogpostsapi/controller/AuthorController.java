package com.dev.blogpostsapi.controller;

import com.dev.blogpostsapi.model.Author;
import com.dev.blogpostsapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @GetMapping
    public Iterable<Author> getAllAuthors(){
        return repository.findAll();
    }

    @GetMapping(path = "name/{firstName}")
    public Author getAuthorByFirstName(@PathVariable String firstName){
        return repository.findByFirstName(firstName);
    }
    @GetMapping(path = "/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public void saveAuthor(@RequestBody Author author){
        repository.save(author);
    }

    @PutMapping(path = "edit/{id}")
    public Optional<Author> updateAuthorData(@RequestBody Author author, @PathVariable Long id){
        repository.findById(id).ifPresent(a ->
        {
            a.setBio(author.getBio());
            a.setEmail(author.getEmail());
        });
        return repository.findById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAuthor(@PathVariable Long id){
        Author author = repository.findById(id).get();
        repository.delete(author);
    }
}
