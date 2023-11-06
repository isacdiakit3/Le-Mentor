package com.mentor.Newton_Universe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Newton_Universe.models.Notification;
import com.mentor.Newton_Universe.services.NotificationService;

/**
 * NotificationController
 */
@RestController
@RequestMapping("notification")
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping("/creer")
    public Notification creer(@RequestBody Notification notification){
        return notificationService.creer(notification);
    }

    @GetMapping("")
    public List<Notification> lire(){
        return notificationService.lire();
    }

    @GetMapping("/{id}")
    public Notification rechercher(@PathVariable Long id){
        return notificationService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public Notification modifier(@PathVariable Long id , @RequestBody Notification notification){
        return notificationService.modifier(id, notification);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return notificationService.supprimer(id);
    }
}