package com.cg.controller;

import com.cg.exception.DuplicateUserException;
import com.cg.exception.InvalidLoginCredentialException;
import com.cg.exception.NoSuchUserException;
import com.cg.model.User;
import com.cg.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    @Autowired

    private UserServiceImpl userService;

//    http://localhost:8081/user/register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws DuplicateUserException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "User registered successfully.");
        return new ResponseEntity<User>(userService.registerUser(user),headers, HttpStatus.CREATED);
    }
//    http://localhost:8081/user/login
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) throws InvalidLoginCredentialException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "User logged in successfully.");
        return new ResponseEntity<User>(userService.loginUser(user), headers,HttpStatus.OK);
    }

//    http://localhost:8081/user/logout
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody String userName) throws NoSuchUserException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "User logged out successfully.");
        return new ResponseEntity<String>(userService.logout(userName), headers, HttpStatus.OK);
    }
}
