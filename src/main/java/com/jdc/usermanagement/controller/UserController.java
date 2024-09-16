package com.jdc.usermanagement.controller;

import com.jdc.usermanagement.dto.UserRequest;
import com.jdc.usermanagement.entity.User;
import com.jdc.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User user = userService.save(userRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest) {
        User updateUser = userService.updateUser(id, userRequest);
        return ResponseEntity.ok(updateUser);
    }

    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        return null;
    }
}
