package com.mentor.Le_Mentor.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Le_Mentor.models.Devoir;
import com.mentor.Le_Mentor.services.DevoirService;

/**
 * DevoirController
 */
@RestController
@RequestMapping("devoir")
public class DevoirController {

    @Autowired
    private DevoirService devoirService;

    @PostMapping("/creer")
    public Devoir creer(@RequestBody Devoir devoir){
        return devoirService.creer(devoir);
    }

    @GetMapping("")
    public List<Devoir> lire(){
        return devoirService.lire();
    }

    @GetMapping("/{id}")
    public Devoir rechercher(@PathVariable Long id){
        return devoirService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public Devoir modifier(@PathVariable Long id , @RequestBody Devoir devoir){
        return devoirService.modifier(id, devoir);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return devoirService.supprimer(id);
    }
}