package com.example.baitap6;


import org.springframework.stereotype.Component;

@Component

public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("1:" + message);
    }
}
