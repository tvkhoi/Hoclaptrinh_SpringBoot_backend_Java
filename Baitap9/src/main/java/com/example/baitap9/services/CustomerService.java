package com.example.baitap9.services;

import com.example.baitap9.models.Customer;
import com.example.baitap9.reponsitories.CustomerRepository;
import com.example.baitap9.services.implement.CustomerServiceStorage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServiceStorage {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Object save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerByFullnameAndPhone(String fullname, String phone) {
        return customerRepository.findCustomerByFullNameAndPhoneNumber(fullname,phone);
    }

    @Override
    public void update(Customer oldCustomer,Customer newCustomer) {
        oldCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
        oldCustomer.setFullName(newCustomer.getFullName());
        oldCustomer.setEmail(newCustomer.getEmail());
        customerRepository.save(oldCustomer);
    }

    @Override
    public List<Customer> findByPhoneNumber(String phoneNumber) {
       return  customerRepository.findByPhoneNumber(phoneNumber);
    }

    @Transactional
    @Override
    public List<Customer> deleteByPhoneNumber(String phoneNumber) {
        List<Customer> customers = customerRepository.findByPhoneNumber(phoneNumber);
        if(customers.size()>0){
            customerRepository.deleteByPhoneNumber(phoneNumber);
            return customers;
        }
       return customers;
    }

    @Override
    public List<Customer> findByFullName(String fullname) {
        return customerRepository.findByFullNameContaining(fullname);
    }


}
