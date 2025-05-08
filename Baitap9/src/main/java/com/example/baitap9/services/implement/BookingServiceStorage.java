package com.example.baitap9.services.implement;

import com.example.baitap9.models.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingServiceStorage {
    public Booking createBooking(Long customerId, List<Long> roomIds, LocalDate bookingDate, LocalDate checkOutDate);

    Booking deleteBooking(Long bookingId);
}
