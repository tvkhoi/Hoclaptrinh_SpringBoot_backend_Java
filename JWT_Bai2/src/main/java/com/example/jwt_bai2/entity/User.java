package com.example.jwt_bai2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Size(min = 8, message = "Tên người dùng ít nhất phải 8 kí tự")
    String username;
    
    @Size(min = 5, message = "Mật khẩu ít nhất phải 5 kí tự")
    String password;
    
    @Pattern(regexp = "USER|ADMIN", message = "Role chỉ được nhận giá trị USER hoặc ADMIN")
    String role;
}
