package com.example.parkease.services;

import com.example.parkease.entities.Booking;
import com.example.parkease.entities.ParkingSpot;
import com.example.parkease.entities.User;
import com.example.parkease.repositories.BookingRepository;
import com.example.parkease.repositories.ParkingSpotRepository;
import com.example.parkease.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, ParkingSpotRepository parkingSpotRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.userRepository = userRepository;
    }

    public Booking createBooking(Long userId, Long parkingSpotId, LocalDateTime startTime, LocalDateTime endTime,  String vehicleNumber) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(parkingSpotId)
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));

        if (!parkingSpot.isAvailableForBooking(startTime, endTime)) {
            throw new RuntimeException("Parking spot is already booked for the selected time slot");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        double hours = Duration.between(startTime, endTime).toHours();
        double totalPrice = hours * parkingSpot.getPricePerHour();

        Booking booking = new Booking();
        booking.setParkingSpot(parkingSpot);
        booking.setUser(user);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setTotalPrice(totalPrice);
        booking.setStatus("Active");
        booking.setVehicleNumber(vehicleNumber); 

        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
