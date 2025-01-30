package com.example.parkease.controllers;

import com.example.parkease.entities.Notification;
import com.example.parkease.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public String getUserNotifications(Model model, Principal principal) {
        Long userId = Long.parseLong(principal.getName()); // Get logged-in user ID
        List<Notification> notifications = notificationService.getUserNotifications(userId);
        model.addAttribute("notifications", notifications);
        return "notifications";
    }

    @PostMapping("/mark-read")
    @ResponseBody
    public void markNotificationsAsRead(Principal principal) {
        Long userId = Long.parseLong(principal.getName());
        notificationService.markNotificationsAsRead(userId);
    }
    
}
