package com.cakeslayer.cakeslayer.service;

import com.cakeslayer.cakeslayer.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
abstract public class UserService {

    abstract public UserEntity saveUser(String username,String password);
    abstract public List<UserEntity> getAllUser();
    abstract public UserEntity getByUsername(String username);




}
