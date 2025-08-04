package com.cakeslayer.cakeslayer.model;


import com.cakeslayer.cakeslayer.dto.RegisterUserDto;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "users")
@Data
public class UserEntity {

    @Id
    @Indexed(unique = true)
    private String username;

    private String name;

    private String password;

    private int age;

    private String address;

    private String phone;

    private Date date;

    private String email;

    @DBRef
    private ProductEntity productEntity;

    public UserEntity toEntity(RegisterUserDto registerUserDto){
        UserEntity userEntity=  new UserEntity();
        userEntity.setPassword(registerUserDto.getPassword());
        userEntity.setUsername(registerUserDto.getUsername());
        userEntity.setAge(registerUserDto.getAge());
        userEntity.setEmail(registerUserDto.getEmail());
        userEntity.setAddress(registerUserDto.getAddress());
        userEntity.setPhone(registerUserDto.getPhone());
        userEntity.setDate(registerUserDto.getDate());
        userEntity.setName(registerUserDto.getName());

       return userEntity;

    }
    public UserEntity toEntityLogin(RegisterUserDto registerUserDto){
        UserEntity userEntity=  new UserEntity();
        userEntity.setPassword(registerUserDto.getPassword());
        userEntity.setUsername(registerUserDto.getUsername());

        return userEntity;

    }


}