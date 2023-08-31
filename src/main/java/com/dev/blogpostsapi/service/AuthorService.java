package com.dev.blogpostsapi.service;

import com.dev.blogpostsapi.data.entity.Author;
import com.dev.blogpostsapi.data.repository.AuthorRepository;
import com.dev.blogpostsapi.error.BadRequestException;
import com.dev.blogpostsapi.error.ConflictException;
import com.dev.blogpostsapi.error.NotFoundException;
import com.dev.blogpostsapi.model.AuthorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        if(authors.isEmpty()){
            throw new NotFoundException("Sorry, Can't find anything");
        }
        List<AuthorDTO> authorDTOS = new ArrayList<>();
       authorDTOS = authors.stream().map(author -> {
                    return new AuthorDTO(
                            author.getId(),
                            author.getFirstName(),
                            author.getLastName(),
                            author.getJobTitle(),
                            author.getBio());
                }
        ).collect(Collectors.toList());

        return authorDTOS;
    }

    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO getAuthorById(Long id){
        if (id == null || id <= 0 || id > 100){
            throw new BadRequestException("Invalid input. Please enter a valid id");
        }
         Author author =authorRepository.findById(id).get();
        return translateToDTO(author);
    }

    public AuthorDTO getAuthorByFirstName(String firstName){
        if (firstName == null || firstName.isEmpty()){
            throw new BadRequestException("Invalid Input value for author name");
        }
        Author author = authorRepository.findByFirstName(firstName);
        return translateToDTO(author);
    }

    public AuthorDTO RegisterNewAuthor(AuthorDTO dto){
        Long id = dto.getId();
        if(id == null || id <= 0){
            throw new BadRequestException("Invalid User Id");
        } else if(authorRepository.findById(id).isPresent()) {
            throw new ConflictException("User Already Exist");
        }
        return translateToDTO(authorRepository.save(translateToAuthorEntity(dto)));
    }

    public AuthorDTO updateAuthorInfo(AuthorDTO dto, Long id){
        if(id == null || id <= 0){
            throw new BadRequestException("Invalid User Id");
        } else if(authorRepository.findById(id).isEmpty()) {
            throw new ConflictException("User Doesn't Exist");
        }
        Author author= translateToAuthorEntity(dto);
        return translateToDTO(authorRepository.save(author));
    }

    public void deleteAuthor(Long id){
        if(id == null || id <= 0){
            throw new BadRequestException("Invalid User Id");
        } else if(authorRepository.findById(id).isEmpty()) {
            throw new ConflictException("User Doesn't Exist");
        }
        Author author = authorRepository.findById(id).get();
        authorRepository.delete(author);
    }

    private AuthorDTO translateToDTO(Author author){
        return new AuthorDTO(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getJobTitle(),
                author.getBio()
        );
    }

    private Author translateToAuthorEntity(AuthorDTO dto){
        return new Author(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getJobTitle(),
                dto.getBio()
        );
    }

}
