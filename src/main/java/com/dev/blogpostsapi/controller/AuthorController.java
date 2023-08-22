package com.dev.blogpostsapi.controller;

import com.dev.blogpostsapi.model.AuthorDTO;
import com.dev.blogpostsapi.data.entity.Author;
import com.dev.blogpostsapi.data.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @GetMapping
    public List<AuthorDTO> getAllAuthors(){
        return repository.findAll()
                .stream()
                .map(author -> {
                    return new AuthorDTO(
                            author.getId(),
                            author.getFirstName(),
                            author.getLastName(),
                            author.getJobTitle(),
                            author.getBio()
                    );
                }).collect(Collectors.toList());
    }

    @GetMapping(path = "name/{firstName}")
    public Author getAuthorByFirstName(@PathVariable String firstName){
        return repository.findByFirstName(firstName);
    }
    @GetMapping(path = "/{id}")
    public Optional<AuthorDTO> getAuthorById(@PathVariable Long id){
        return repository.findById(id)
                .map(author -> {
                    return new AuthorDTO(
                            author.getId(),
                            author.getFirstName(),
                            author.getLastName(),
                            author.getJobTitle(),
                            author.getBio()
                    );
                });
    }

    @PostMapping
    public void saveAuthor(@RequestBody Author author){
        repository.save(author);
    }

    @PutMapping(path = "edit/{id}")
    public ResponseEntity<AuthorDTO> updateAuthorData(@RequestBody Author author, @PathVariable Long id){

        repository.findById(id).ifPresent(a -> {
            a.setBio(author.getBio());
            a.setEmail(author.getEmail());
        });
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AuthorDTO(
                   author.getId(),
                   author.getFirstName(),
                   author.getLastName(),
                   author.getJobTitle(),
                        author.getBio()
                ));
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAuthor(@PathVariable Long id){
        Author author = repository.findById(id).get();
        repository.delete(author);
    }

}
