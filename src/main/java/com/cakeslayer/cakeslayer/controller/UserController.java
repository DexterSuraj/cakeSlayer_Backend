package com.cakeslayer.cakeslayer.controller;

import com.cakeslayer.cakeslayer.dto.UserDto;
import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> adduser(@RequestBody UserDto userDto) {
        try {
            if (userDto.getUsername() == null || userDto.getUsername().isBlank()
                    || userDto.getPassword() == null || userDto.getPassword().isBlank()) {
                return ResponseEntity.badRequest().body("Username and password are required.");
            }

            UserEntity checkUser = userService.getByUsername(userDto.getUsername());
            if (checkUser != null) {
                return ResponseEntity.status(400).body("User already exists");
            }

            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            UserEntity userEntity = userService.saveUser(userDto.getUsername(), encodedPassword);

            return ResponseEntity.status(201).body(userEntity);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser(){
        try{
        List <UserEntity>lst= userService.getAllUser();
        return ResponseEntity.status(200).body(lst);
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
}
