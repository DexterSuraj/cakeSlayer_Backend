package com.cakeslayer.cakeslayer.service.serviceImpl;

import com.cakeslayer.cakeslayer.dto.RegisterUserDto;
import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.repository.UserRepository;
import com.cakeslayer.cakeslayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserEntity saveUser(RegisterUserDto registerUserDto) {
        UserEntity userEntity=new UserEntity();
        userEntity=userEntity.toEntity(registerUserDto);
        return userRepository.save(userEntity);
    }
    @Override
    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }



}
