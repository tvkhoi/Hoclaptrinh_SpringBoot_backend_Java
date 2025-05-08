package com.example.baitap9.controllers;

import com.example.baitap9.models.Booking;
import com.example.baitap9.models.ReposeObject;
import com.example.baitap9.services.BookingService;
import com.example.baitap9.services.CustomerService;
import com.example.baitap9.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("api/v1/Bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<ReposeObject> createBooking(@RequestParam Long customerId, @RequestParam List<Long> roomId
            , @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate) {

        Booking booking = bookingService.createBooking(customerId, roomId, bookingDate, checkOutDate);
        if(booking == null) {
            return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ReposeObject("false","Not insert booking", "")
            );
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ReposeObject("Ok","Insert booking", booking)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ReposeObject> deleteBooking(@PathVariable Long id) {
        Booking booking = bookingService.deleteBooking(id);
        if(booking == null) {
            return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ReposeObject("false","Not insert booking", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposeObject("Ok","Delete booking", booking)
        );
    }
    @GetMapping("/getAllBooking")
    public ResponseEntity<ReposeObject> getAllBooking(Pageable pageable) {
       Page<Booking> bookingPaget =  bookingService.getALLBookings(pageable);
       if(bookingPaget == null) {
           return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                   new ReposeObject("false","Not insert booking", "")
           );
       }
       return ResponseEntity.status(HttpStatus.OK).body(
               new ReposeObject("Ok","Get all bookings", bookingPaget)
       );
    }

}
