package com.dev.blogpostsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public Iterable<User> getAllUsers(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return repository.save(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        User user = repository.findById(id).get();
        repository.delete(user);
    }
}
