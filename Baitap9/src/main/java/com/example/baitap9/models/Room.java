package com.example.baitap9.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roomNumber;
    String type; // standard, deluxe, suite
    BigDecimal price;
    String status; // available, booked
    @ManyToMany(mappedBy = "rooms")
    @JsonBackReference
    List<Booking> bookings;
}
