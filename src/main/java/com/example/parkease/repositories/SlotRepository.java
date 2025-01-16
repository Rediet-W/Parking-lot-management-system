package com.example.parkease.repositories;

import com.example.parkease.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}
