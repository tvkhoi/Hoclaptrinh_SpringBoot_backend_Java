package com.example.baitap7.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(nullable = false, unique = true, length = 50)
    String name;
    double price;
    String url;

    public Product(String name, double price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public Product() {

    }
}
