package com.example.baitap3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("singleton")
public class AppConfig {

    @Bean
    public Girl girl() {
        return new Girl();
    }
}
