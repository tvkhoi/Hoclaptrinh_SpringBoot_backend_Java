package com.example.baitap7.controllers;

import com.example.baitap7.models.Product;
import com.example.baitap7.models.ResponseObject;
import com.example.baitap7.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
//this is url "http://localhost:8080/api/v1/Product"
@RequestMapping(path = "/api/v1/Product")
public class ProductController {
    //DI = Dependency Injection
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getAllProducts")
    List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    //Get detail product
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Query product Success",product)
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","No product found with this id "+ id,"")
            );
        }
    }
    //Insert Product using @PostMapping
    @PostMapping("/insertProduct")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        List<Product> products = productRepository.findProductByName(newProduct.getName());
        if(products.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("false","Product name is already taken!", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Insert product Success",productRepository.save(newProduct)));
    }
    //Update Product using @PutMapping
    @PutMapping("/updateProduct/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct , @PathVariable int id) {
        Product product = (Product) productRepository.findById(id)
                .map(product1 -> {
                    product1.setName(newProduct.getName());
                    product1.setPrice(newProduct.getPrice());
                    product1.setUrl(newProduct.getUrl());
                    return productRepository.save(product1);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Update product Success",product));
    }

    //Delete Product using @DeleteMapping
    @DeleteMapping("/deleteProduct/{id}")
    ResponseEntity<ResponseObject> deleteMapping(@PathVariable int id) {
        boolean exists = productRepository.existsById(id);
        if(exists) {
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Delete product Success",""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false","Product not found!", ""));

    }

}
