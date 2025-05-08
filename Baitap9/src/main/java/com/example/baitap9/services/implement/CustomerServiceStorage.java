package com.example.baitap9.services.implement;

import com.example.baitap9.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceStorage {
    public Optional<Customer> findById(Long id);
    public Object save(Customer customer);
    public List<Customer> findAll();
    public Optional<Customer> findCustomerByFullnameAndPhone(String fullname, String phone);
    public void update(Customer oldCustomer,Customer newCustomer);
    public List<Customer> findByPhoneNumber(String phoneNumber);
    public List<Customer> deleteByPhoneNumber(String phoneNumber);
    public List<Customer> findByFullName(String fullname);
}
