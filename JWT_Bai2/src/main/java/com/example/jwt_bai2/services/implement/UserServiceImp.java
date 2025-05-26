package com.example.jwt_bai2.services.implement;

import com.example.jwt_bai2.dto.AuthRequest;
import com.example.jwt_bai2.entity.User;

import java.util.Optional;

public interface UserServiceImp {
    User registerUser(User user);
    String login(AuthRequest authRequest);
}
