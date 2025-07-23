package com.cakeslayer.cakeslayer.service;

import com.cakeslayer.cakeslayer.dto.RegisterUserDto;
import com.cakeslayer.cakeslayer.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
abstract public class UserService {

    abstract public UserEntity saveUser(RegisterUserDto registerUserDto);
    abstract public List<UserEntity> getAllUser();
    abstract public UserEntity getByUsername(String username);



}
