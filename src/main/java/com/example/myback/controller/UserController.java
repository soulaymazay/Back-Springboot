package com.example.myback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.myback.entity.User;
import com.example.myback.service.UserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RequestMapping("/backend")
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    


    @Autowired
    private UserService userService;

    @GetMapping("/users/{userid}")
    
    public ResponseEntity<User> getUserById(@PathVariable("userid") int userid) { // Utilisez int ici
        User user = userService.getUser(userid); // Utilisez int ici
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users")
    
    public ResponseEntity<List<User>> getAllUsers() { // Utilisez int ici
        List<User> users = userService.getAllUsers(); // Utilisez int ici
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticate(user.getEmail(), user.getPassword());
        
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
}}

    
    

