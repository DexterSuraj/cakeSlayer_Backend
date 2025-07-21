package com.cakeslayer.cakeslayer.controller;

import com.cakeslayer.cakeslayer.dto.UserDto;
import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

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

//            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            UserEntity userEntity = userService.saveUser(userDto.getUsername(), userDto.getPassword(),userDto.getAge());

            return ResponseEntity.status(201).body(userEntity);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());        }
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

    @PostMapping("/login")
    public ResponseEntity<?> authUser(@RequestBody String username,String password){
        UserEntity userEntity=new UserEntity();
        String checkUsername= userEntity.getUsername();
        String checkPassword= userEntity.getPassword();
        if(checkPassword.equals(password) && checkUsername.equals(username)){

        return new ResponseEntity<>("User Logged IN Succeussfully", HttpStatusCode.valueOf(200));
        }
        else {
            return new ResponseEntity<>("Enter valid credentials",HttpStatus.BAD_REQUEST);
        }
    }

}
