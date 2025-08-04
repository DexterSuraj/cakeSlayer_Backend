package com.cakeslayer.cakeslayer.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class LoginUserDto {
    private String username;
    private String password;
}
