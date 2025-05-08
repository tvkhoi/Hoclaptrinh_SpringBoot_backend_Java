package com.example.baitap9.controllers;

import com.example.baitap9.models.Customer;
import com.example.baitap9.models.ReposeObject;
import com.example.baitap9.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<ReposeObject> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        if(customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReposeObject("false","Can not find",""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposeObject("OK","Get all customers",customers)
        );
    }
    @PostMapping("/insertCustomer")
    public ResponseEntity<ReposeObject> insertCustomer(@RequestBody Customer customer) {
        customer.setBookings(new ArrayList<>());
        Optional<Customer> customerList = customerService.findCustomerByFullnameAndPhone(customer.getFullName(),customer.getPhoneNumber());
        boolean exists = customerList.map(cus -> customer.getFullName().equals(cus.getFullName()) && customer.getPhoneNumber().equals(cus.getPhoneNumber())).orElse(false);
        if (!exists) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReposeObject("Ok","Insert succesfull",customerService.save(customer))
            );

        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ReposeObject("false","Can not insert","")
        );
    }
    @PutMapping("/updateCustomer/{phoneNumber}")
    public ResponseEntity<ReposeObject> updateCustomer(@PathVariable String phoneNumber,@RequestBody Customer newCustomer) {
        List<Customer> oldCustomer = customerService.findByPhoneNumber(phoneNumber);
        if(oldCustomer.size() != 0) {
            customerService.update(oldCustomer.get(0), newCustomer);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReposeObject("Ok","Update succesfull",oldCustomer.get(0))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ReposeObject("false","Can not update","")
        );
    }

    @DeleteMapping("/deleteCustomer/{phoneNumber}")
    public ResponseEntity<ReposeObject> deleteCustomer(@PathVariable String phoneNumber) {
        List<Customer> cus = customerService.deleteByPhoneNumber(phoneNumber);
        if(cus.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReposeObject("false","Can not delete","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposeObject("Ok","Delete succesfull",cus.get(0))
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ReposeObject> searchCustomerByFullname(@RequestParam String fullName) {
        List<Customer> customerList = customerService.findByFullName(fullName);
        if(customerList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReposeObject("false","Can not find","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposeObject("Ok","Search succesfull",customerList.get(0))
        );
    }


}
