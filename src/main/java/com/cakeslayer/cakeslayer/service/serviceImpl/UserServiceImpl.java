package com.cakeslayer.cakeslayer.service.serviceImpl;

import com.cakeslayer.cakeslayer.dto.UserDto;
import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.repository.UserRepository;
import com.cakeslayer.cakeslayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl extends UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @Transactional
    public UserEntity saveUser(String username, String password, int age) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(username);
//        String pwd= passwordEncoder.encode(password);
        userEntity.setPassword(password);
        userEntity.setAge(age);
        return userRepository.save(userEntity);
    }
    @Override
    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public UserEntity getByUsername(String username) {
    userRepository.findById(username);
    return null;
    }


}
