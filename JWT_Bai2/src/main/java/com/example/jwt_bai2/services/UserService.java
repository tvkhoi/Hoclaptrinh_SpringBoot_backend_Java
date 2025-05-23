package com.example.jwt_bai2.services;

import com.example.jwt_bai2.dto.AuthRequest;
import com.example.jwt_bai2.entity.User;
import com.example.jwt_bai2.repositories.UserRepository;
import com.example.jwt_bai2.securities.JwtUltil;
import com.example.jwt_bai2.services.implement.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUltil jwtUltil;


    @Override
    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Tên người dùng đã tồn tại");
        }

        String role = user.getRole();
        if (role == null || !(role.equals("USER") || role.equals("ADMIN"))) {
            throw new IllegalArgumentException("Vai trò không hợp lệ (chỉ chấp nhận USER hoặc ADMIN");
        }

        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUltil.generateToken(authRequest.getUsername());
        return token;
    }


}
