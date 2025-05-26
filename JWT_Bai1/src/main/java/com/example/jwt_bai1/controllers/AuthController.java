package com.example.jwt_bai1.controllers;

import com.example.jwt_bai1.dto.JwtResponse;
import com.example.jwt_bai1.dto.LoginRequest;
import com.example.jwt_bai1.dto.RegisterRequest;
import com.example.jwt_bai1.entity.User;
import com.example.jwt_bai1.repositories.UserRepository;
import com.example.jwt_bai1.security.JwtUtils;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    // Đăng ký người dùng
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        logger.info("Registering user: {}", request.getUsername());
        // Kiểm tra username đã tồn tại
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        // Kiểm tra vai trò hợp lệ
        String role = request.getRole();
        if (role == null || !(role.equals("USER") || role.equals("ADMIN"))) {
            return ResponseEntity.badRequest().body("Invalid role. Must be USER or ADMIN");
        }

        // Tạo người dùng mới
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        userRepository.save(user);
        logger.info("User registered successfully: {}", request.getUsername());
        return ResponseEntity.ok("User registered successfully");
    }

    // Đăng nhập và tạo JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        logger.info("Attempting to login user: {}", request.getUsername());
        try {
            logger.debug("Authenticating user: {}", request.getUsername());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()
                    )
            );

            logger.debug("Authentication successful for user: {}", request.getUsername());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            logger.debug("Generating JWT for user: {}", authentication.getName());
            String jwt = jwtUtils.generateJwtToken(authentication.getName());
            logger.debug("JWT generated successfully: {}", jwt);

            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (UsernameNotFoundException e) {
            logger.warn("User not found: {}", request.getUsername());
            return ResponseEntity.badRequest().body("User not found: " + request.getUsername());
        } catch (BadCredentialsException e) {
            logger.warn("Bad credentials for user: {}", request.getUsername());
            return ResponseEntity.badRequest().body("Invalid username or password");
        } catch (DisabledException e) {
            logger.warn("User account disabled: {}", request.getUsername());
            return ResponseEntity.badRequest().body("User account is disabled");
        } catch (Exception e) {
            logger.error("Login failed for user: {} - Error: {}", request.getUsername(), e.getMessage(), e);
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }
}