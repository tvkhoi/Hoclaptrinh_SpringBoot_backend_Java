package com.example.baitap6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Client {

    @Autowired
    @Qualifier("emailService")
    private MessageService emailService;
    public void showMessage(String message) {
        emailService.sendMessage(message);
    }

}
