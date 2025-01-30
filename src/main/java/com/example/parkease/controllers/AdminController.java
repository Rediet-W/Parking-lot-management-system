package com.example.parkease.controllers;

import com.example.parkease.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class AdminController {

    private final BookingService bookingService;

    @Autowired
    public AdminController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard(@RequestParam(required = false) String start, 
                                @RequestParam(required = false) String end, 
                                Model model) {
        LocalDate startDate = (start != null) ? LocalDate.parse(start) : LocalDate.now().minusDays(7);
        LocalDate endDate = (end != null) ? LocalDate.parse(end) : LocalDate.now();

        Map<String, Object> dashboardData = bookingService.getDashboardData(startDate, endDate);

        model.addAllAttributes(dashboardData);
        return "admin/dashboard";
    }
}
