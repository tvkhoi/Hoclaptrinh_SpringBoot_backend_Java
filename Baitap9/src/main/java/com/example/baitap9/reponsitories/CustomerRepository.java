package com.example.baitap9.reponsitories;

import com.example.baitap9.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Override
    Optional<Customer> findById(Long aLong);
    @Override
    List<Customer> findAll();
    List<Customer> findByPhoneNumber(String phoneNumber);
    Optional<Customer> findCustomerByFullNameAndPhoneNumber(String fullName, String phoneNumber);

    List<Customer> deleteByPhoneNumber(String phoneNumber);
    List<Customer> findByFullNameContaining(String fullName);
}
