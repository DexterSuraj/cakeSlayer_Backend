package com.cakeslayer.cakeslayer.dto;

import lombok.Data;

import java.util.Date;


@Data

public class RegisterUserDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private int age;
    private String address;

    private String phone;

    private Date date;

}
