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

import com.mentor.Le_Mentor.models.DemandeMentorat;
import com.mentor.Le_Mentor.services.DemandeMentoratService;

/**
 * DemandeMentoratController
 */
@RestController
@RequestMapping("demande_mentorat")
public class DemandeMentoratController {
    
    @Autowired
    private DemandeMentoratService demandeMentoratService;

    @PostMapping("/creer")
    public DemandeMentorat creer(@RequestBody DemandeMentorat demandeMentorat){
        return demandeMentoratService.creer(demandeMentorat);
    }

    @GetMapping("")
    public List<DemandeMentorat> lire(){
        return demandeMentoratService.lire();
    }

    @GetMapping("/{id}")
    public DemandeMentorat rechercher(@PathVariable Long id){
        return demandeMentoratService.rechercher(id);
    }

    @PutMapping ("/modifier/{id}")
    public DemandeMentorat modifier(@PathVariable Long id , @RequestBody DemandeMentorat demandeMentorat){
        return demandeMentoratService.modifier(id, demandeMentorat);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return demandeMentoratService.supprimer(id);
    }
}
