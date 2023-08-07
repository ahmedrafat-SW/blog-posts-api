package com.dev.blogpostsapi.registration;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/login")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class LoginController {


    private UserService userService;
    @PostMapping
    public ResponseEntity<?> performLogin(@Valid @RequestBody LoginRequestDto loginDTO,
                                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
//           Handle validation errors and return proper response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getValidationErrors(bindingResult));
        }if (!userService.isUserValid(loginDTO.getEmail(), loginDTO.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }else
            return ResponseEntity.ok("Success !");
    }

    private Map<String, String> getValidationErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }
}