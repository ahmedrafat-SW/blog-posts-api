package com.dev.blogpostsapi.controller;

import com.dev.blogpostsapi.model.AuthorDTO;
import com.dev.blogpostsapi.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthors(){
        return service.getAllAuthors();
    }

    @GetMapping(path = "name")
    public AuthorDTO getAuthorByFirstName(@RequestParam String firstName){
        return service.getAuthorByFirstName(firstName);
    }
    @GetMapping(path = "/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id){
        return service.getAuthorById(id);
    }

    @PostMapping
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO author){
        return service.RegisterNewAuthor(author);
    }

    @PutMapping(path = "edit/{id}")
    public AuthorDTO updateAuthorData(@RequestBody AuthorDTO author, @PathVariable Long id){
        return service.updateAuthorInfo(author, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAuthor(@PathVariable Long id){
        service.deleteAuthor(id);
    }

}
