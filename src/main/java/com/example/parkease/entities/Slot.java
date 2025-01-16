package com.example.parkease.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slotNumber;

    @Column(nullable = false)
    private String type; // e.g., Compact, SUV, Two-Wheeler

    @Column(nullable = false)
    private String status; // e.g., Available, Occupied, Reserved

    @Column(nullable = false)
    private BigDecimal pricePerHour;
}
