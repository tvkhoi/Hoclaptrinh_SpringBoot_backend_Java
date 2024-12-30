package com.example.baitap7.repositories;

import com.example.baitap7.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByName(String name);
}
