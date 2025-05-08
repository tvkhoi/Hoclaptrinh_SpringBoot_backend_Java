package com.example.baitap9.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String fullName;
    String email;
    String phoneNumber;
    LocalDate birthDate;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    List<Booking> bookings = new ArrayList<>();
}
