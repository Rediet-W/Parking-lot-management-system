package com.example.parkease.repositories;

import com.example.parkease.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId); // Get bookings for a specific user
}
