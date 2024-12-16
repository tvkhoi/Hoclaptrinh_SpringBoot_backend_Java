package com.example.baitap6;



public class AppConfig {


    public EmailService emailService() {
        return new EmailService();

    }

    public EmailService emailService2() {
        return new EmailService();
    }
}
