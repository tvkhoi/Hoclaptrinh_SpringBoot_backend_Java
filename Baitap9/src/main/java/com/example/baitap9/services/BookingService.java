package com.example.baitap9.services;

import com.example.baitap9.models.Booking;
import com.example.baitap9.models.Customer;
import com.example.baitap9.models.Room;
import com.example.baitap9.reponsitories.BookingRepository;
import com.example.baitap9.reponsitories.CustomerRepository;
import com.example.baitap9.reponsitories.RoomRepository;
import com.example.baitap9.services.implement.BookingServiceStorage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService implements BookingServiceStorage {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Booking createBooking(Long customerId, List<Long> roomIds, LocalDate bookingDate, LocalDate checkOutDate) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new RuntimeException("Customer not found with id: " + customerId)
        );
        List<Room> rooms = roomRepository.findAllById(roomIds);
        if(roomIds.size() != rooms.size()) {
            throw new RuntimeException("One or more rooms not found");
        }
        // Check if rooms are available
        for (Room room : rooms) {
            if(!"available".equalsIgnoreCase(room.getStatus())) {
                throw new RuntimeException("Room" + room.getRoomNumber()+ "is not available");
            }
        }
        // Calculate total cost
        BigDecimal totalPrice = rooms.stream().map(Room::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setRooms(rooms);
        booking.setBookingDate(bookingDate);
        booking.setCheckOutDate(checkOutDate);
        booking.setTotalCost(totalPrice);

        // Update room status to booked
        rooms.forEach(room -> room.setStatus("booked"));
        // Update room attribute booking
//        rooms.forEach(room -> room.setBooking(booking));
        roomRepository.saveAll(rooms);

        return bookingRepository.save(booking);
    }
    @Transactional
    @Override
    public Booking deleteBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found with id: " + bookingId));
        LocalDate currentDate = LocalDate.now();

        // Kiểm tra nếu Booking đã hết hạn
        if (currentDate.isAfter(booking.getCheckOutDate())) {
            // Đổi trạng thái các phòng thành "available" nếu cần
            for (Room room : booking.getRooms()) {
                if ("booked".equalsIgnoreCase(room.getStatus())) {
                    room.setStatus("available");
                    //booking.getRooms().remove(room);
                }
            }

            roomRepository.saveAll(booking.getRooms());
            //booking.getRooms().clear();
            bookingRepository.deleteById(bookingId);
        } else {
            throw new RuntimeException("Cannot delete booking as it has not yet expired.");
        }
        return booking;
    }
    public Page<Booking> getALLBookings(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }

}
