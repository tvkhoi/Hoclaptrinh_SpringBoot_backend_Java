package com.example.baitap4.Other;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Girl {
    public Girl() {
        System.out.println("Girl được khởi tạo");
    }
}
