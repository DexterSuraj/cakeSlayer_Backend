package com.cakeslayer.cakeslayer.dto;

import lombok.Data;
import org.hibernate.annotations.DialectOverride;

@Data

public class UserDto {
    private String username;
    private String password;
}
