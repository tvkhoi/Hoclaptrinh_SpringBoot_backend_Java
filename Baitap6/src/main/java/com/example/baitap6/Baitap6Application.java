package com.example.baitap6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Baitap6Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Baitap6Application.class, args);
        Client client = context.getBean(Client.class);
        client.showMessage("hello");
    }

}
