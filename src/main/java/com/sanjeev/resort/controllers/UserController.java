package com.sanjeev.resort.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sanjeev.resort.models.User;
import com.sanjeev.resort.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        // First, check if the user exists
        Optional<User> existingUser = userService.getUserById(id);
        if (existingUser.isPresent()) {
            // Update the user data with the provided data
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername()); // Update other fields as needed
            // Save the updated user
            return userService.saveUser(updatedUser);
        } else {
            // User not found, return null or throw an exception
            return null; // You may want to handle this differently based on your requirements
        }
    }
}