package com.example.baitap3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Baitap3Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Baitap3Application.class, args);

        Girl girl = context.getBean(Girl.class);
        System.out.println("Girl: "+girl);

    }

}
