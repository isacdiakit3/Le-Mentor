package com.mentor.Newton_Universe.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Newton_Universe.ApiResponse;
import com.mentor.Newton_Universe.models.Mentor;
import com.mentor.Newton_Universe.services.MentorService;

/**
 * MentorController
 */
@RestController
@RequestMapping("mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @PostMapping("/inscrire")
    public Mentor inscrire(@RequestBody Mentor mentor){
        return mentorService.inscrire(mentor);
    }

    @GetMapping("")
    public List<Mentor> lire(){
        return mentorService.Lire();
    }

    @GetMapping("/{id}")
    public Mentor rechercher(@PathVariable Long id){
        return mentorService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public Mentor modifier(@PathVariable Long id , @RequestBody Mentor mentor){
        return mentorService.modifier(id, mentor);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return mentorService.supprimer(id);
    }

    @PostMapping("/connexion")
    public ApiResponse connexion(@RequestParam String email , String password){
        return mentorService.login(email, password);
    }
}