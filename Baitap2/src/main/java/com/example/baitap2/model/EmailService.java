package com.example.baitap2.model;


import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {


    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
