package com.example.baitap9.reponsitories;

import com.example.baitap9.models.Booking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Optional<Booking> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    Page<Booking> findAll(Pageable pageable);
}
