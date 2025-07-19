package com.cakeslayer.cakeslayer.service;

import com.cakeslayer.cakeslayer.model.UserEntity;
import com.cakeslayer.cakeslayer.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
abstract public class UserService {

    abstract public UserEntity saveUser(String username,String password);
    abstract public List<UserEntity> getUser();
}
