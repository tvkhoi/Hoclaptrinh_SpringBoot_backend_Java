package com.example.jwt_bai2.controllers;

import com.example.jwt_bai2.aop.HandlBusinessException;
import com.example.jwt_bai2.dto.AuthRequest;
import com.example.jwt_bai2.entity.ReposeObject;
import com.example.jwt_bai2.entity.User;
import com.example.jwt_bai2.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @HandlBusinessException
    public ResponseEntity<ReposeObject> registerUser(@RequestBody User user){
        User userOptional = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ReposeObject("200","Đăng kí thành công",""));
    }
    @PostMapping("/login")
    public ResponseEntity<ReposeObject> loginUser(@RequestBody AuthRequest authRequest){
        String token = userService.login(authRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new ReposeObject("200","Đăng nhập thành công",token));
    }
    @GetMapping("/user/home")
    public ResponseEntity<ReposeObject> homeUser(){
        return ResponseEntity.status(HttpStatus.OK).body(new ReposeObject("200","Truy cập trang chủ user thành công","Trang chủ user"));
    }

    @GetMapping("admin/home")
    public ResponseEntity<ReposeObject> homeAdmin() {
        return ResponseEntity.status(HttpStatus.OK).body(new ReposeObject("200", "Truy cập trang chủ admin thành công", "Trang chủ amdin"));
    }
}
