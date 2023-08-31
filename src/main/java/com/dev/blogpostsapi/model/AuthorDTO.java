package com.dev.blogpostsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDTO{
    private Long id;
    private String firstName;
    private String lastName;
    private String JobTitle ;
    private String bio;
}