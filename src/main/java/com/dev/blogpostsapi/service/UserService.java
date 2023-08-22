package com.dev.blogpostsapi.service;

import com.dev.blogpostsapi.data.entity.Author;
import com.dev.blogpostsapi.model.AuthorDTO;

public class UserService {

    public Author convertToAuthor(AuthorDTO dto){
        return new Author();
    }

    public AuthorDTO convertToDTO(Author author){
        return null;
    }

    public Author saveAuthor(AuthorDTO authorDTO){
        return null;
    }

    public Author updateAuthor(AuthorDTO authorDTO){
        return null;
    }

    public void deleteAuthor(AuthorDTO dto){

    }

}
