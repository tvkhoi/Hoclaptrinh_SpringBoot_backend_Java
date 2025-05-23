package com.example.jwt_bai1.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
