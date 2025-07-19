package com.cakeslayer.cakeslayer.repository;

import com.cakeslayer.cakeslayer.model.UserEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity,String> {



}
