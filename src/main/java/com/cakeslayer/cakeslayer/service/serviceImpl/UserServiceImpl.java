package com.cakeslayer.cakeslayer.service.serviceImpl;

import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.repository.UserRepository;
import com.cakeslayer.cakeslayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl extends UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(String username, String password) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        return userRepository.save(userEntity);
    }
    @Override
    public List<UserEntity> getUser(){
        return userRepository.findAll();
    }
}
