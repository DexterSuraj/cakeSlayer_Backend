package com.cakeslayer.cakeslayer.controller;

import com.cakeslayer.cakeslayer.dto.UserDto;
import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.service.UserService;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> adduser(@RequestBody UserDto userDto){
        try {
            System.out.println("username "+userDto.getUsername());
            System.out.println("password "+userDto.getPassword());
            UserEntity userEntity = userService.saveUser(userDto.getUsername(), userDto.getPassword());

            return ResponseEntity.status(201).body(userEntity);
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser(){
        try{
        List <UserEntity>lst= userService.getUser();
        return ResponseEntity.status(200).body(lst);
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
}
