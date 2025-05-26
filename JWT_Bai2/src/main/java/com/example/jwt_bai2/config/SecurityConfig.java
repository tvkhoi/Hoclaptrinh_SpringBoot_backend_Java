package com.example.jwt_bai2.config;

import com.example.jwt_bai2.securities.JwtAuthenticationFiler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFiler jwtAuthenticationFiler;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(reqest ->
                        reqest.requestMatchers("/api/v1/users/login","/api/v1/users/register").permitAll()
                                .requestMatchers("/api/v1/users/admin/**").hasRole("ADMIN")
                                .requestMatchers("/api/v1/users/user/**").hasRole("USER").anyRequest().authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(new Http403ForbiddenEntryPoint()))
                .addFilterBefore(jwtAuthenticationFiler, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
