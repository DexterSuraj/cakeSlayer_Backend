package com.cakeslayer.cakeslayer.repository;

import com.cakeslayer.cakeslayer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,String> {


}
