package com.example.baitap2.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Client {
    @Autowired
    private EmailService emailService;

    public void processMessage(String message) {
        emailService.sendMessage(message);
    }

}
