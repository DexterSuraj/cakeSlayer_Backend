package com.cakeslayer.cakeslayer.controller;

import com.cakeslayer.cakeslayer.dto.LoginUserDto;
import com.cakeslayer.cakeslayer.dto.RegisterUserDto;
import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.repository.UserRepository;
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

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger log=Logger.getLogger(String.valueOf(UserController.class));
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
@Autowired
    UserRepository userRepository;


    @PostMapping("/signup")
    public ResponseEntity<?> adduser(@RequestBody RegisterUserDto registerUserDto) {
         try{
            if (registerUserDto.getUsername() == null || registerUserDto.getUsername().isBlank()
                    || registerUserDto.getPassword() == null || registerUserDto.getPassword().isBlank()) {
                log.info("It a Username : "+registerUserDto.getUsername()+"Its a Password : "+registerUserDto.getPassword());

                return ResponseEntity.badRequest().body("Username and password are required.");
            }

            Optional<UserEntity> checkUser = userRepository.findById(registerUserDto.getUsername());
            if (checkUser.isPresent()) {
                return ResponseEntity.status(400).body("User already exists");
            }

            String encodedPassword = passwordEncoder.encode(registerUserDto.getPassword());
            registerUserDto.setPassword(encodedPassword);
            UserEntity userEntity = userService.saveUser(registerUserDto);
            log.info("encodedPassword"+encodedPassword+userEntity);
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
    public ResponseEntity<String> authUser(@RequestBody LoginUserDto loginUserDto) {
        String username = loginUserDto.getUsername();
        String password = loginUserDto.getPassword();
        System.out.println(username+" : "+password);

        Optional<UserEntity> optionalUser = userRepository.findById(username);


        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        UserEntity user = optionalUser.get();
        System.out.println("optional User: "+user.getUsername()+" : "+user.getPassword());

        if (passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        } else {
//            if(user.getPassword().equals(loginUserDto.getPassword())){
//                return new ResponseEntity<>("Login succesfull!!",HttpStatus.OK);
//            }
            return new ResponseEntity<>("Invalid credentials", HttpStatus.BAD_REQUEST);
        }
    }


}
