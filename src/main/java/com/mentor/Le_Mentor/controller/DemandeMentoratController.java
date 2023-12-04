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
import com.mentor.Le_Mentor.services.EtudiantService;
import com.mentor.Le_Mentor.services.MentorService;

import jakarta.validation.Valid;

/**
 * DemandeMentoratController
 */
@RestController
@RequestMapping("demande_mentorat")
public class DemandeMentoratController {
    
    @Autowired
    private DemandeMentoratService demandeMentoratService;
    @Autowired
    private MentorService mentorService;
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/creer/{mentorId}/{etudiantId}")
    public DemandeMentorat creerDemande(@Valid @RequestBody DemandeMentorat demandeMentorat, @PathVariable Long mentorId,@PathVariable Long etudiantId){
        demandeMentorat.setMentor(mentorService.rechercher(mentorId));
        demandeMentorat.setEtudiant(etudiantService.rechercher(etudiantId));
        System.out.println(demandeMentorat.getMentor().getNom()+" "+demandeMentorat.getMentor().getPrenom());
        System.out.println(demandeMentorat);
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
