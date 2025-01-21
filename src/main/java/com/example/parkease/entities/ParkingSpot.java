package com.example.parkease.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String type; // Example: Compact, Large, Electric

    @Column(nullable = false)
    private Double pricePerHour;

    @OneToMany(mappedBy = "parkingSpot", cascade = CascadeType.ALL)
    private List<Booking> bookings; // A spot can have multiple bookings

    // Method to check if this spot is available for a given time range
    public boolean isAvailableForBooking(LocalDateTime startTime, LocalDateTime endTime) {
        for (Booking booking : bookings) {
            if (booking.getStatus().equals("Active") &&
                startTime.isBefore(booking.getEndTime()) &&
                endTime.isAfter(booking.getStartTime())) {
                return false; // Spot is occupied during this time
            }
        }
        return true;
    }
}
