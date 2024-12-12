package com.example.baitap4.Other;

import com.example.baitap4.Boy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("prototype")
public class AppConfig {

    @Bean
    public Boy boy() {
        return new Boy();
    }
}
