package com.cakeslayer.cakeslayer.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
@Data
public class UserEntity {

    @Id
    private String username;


    private String password;
}