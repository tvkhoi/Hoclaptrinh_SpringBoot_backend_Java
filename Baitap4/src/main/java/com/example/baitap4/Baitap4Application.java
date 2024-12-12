package com.example.baitap4;

import com.example.baitap4.Other.Girl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication()

public class Baitap4Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Baitap4Application.class, args);

        System.out.println("Run application");
        Girl girl = (Girl) context.getBean(Girl.class);
        System.out.println("Girl: "+girl);


    }

}
