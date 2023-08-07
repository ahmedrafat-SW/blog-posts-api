package com.dev.blogpostsapi.registration;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotNull(message = "Email is required.")
    @Size(min = 1, message = "Email is required.")
    @Email(message = "Email is not well formatted.")

    private String email;

    @NotNull(message = "Password Required")
    @Size(min = 6, message = "Password must should be at least 6 characters ")
    private String password;


}
