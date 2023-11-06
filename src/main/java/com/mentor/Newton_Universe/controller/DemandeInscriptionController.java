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

import com.mentor.Newton_Universe.models.DemandeInscription;
import com.mentor.Newton_Universe.services.DemandeInscriptionService;

/**
 * DemandeInscription
 */
@RestController
@RequestMapping("demande_inscription")
public class DemandeInscriptionController {

    
    private DemandeInscriptionService demandeInscriptionService;

    @GetMapping("")
    public List<DemandeInscription> lire(){
        return demandeInscriptionService.lire();
    }

    @GetMapping("/{id}")
    public com.mentor.Newton_Universe.models.DemandeInscription rechercher(@PathVariable Long id){
        return demandeInscriptionService.rechercher(id);
    }

    @PostMapping("/creer")
    public DemandeInscription creer(@RequestBody DemandeInscription demandeInscription){
        return demandeInscriptionService.creer(demandeInscription);
    }

    @PutMapping("/modifier/{id}")
    public DemandeInscription modifier(@PathVariable Long id , @RequestBody DemandeInscription demandeInscription){
        return demandeInscriptionService.modifier(id, demandeInscription);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return demandeInscriptionService.supprimer(id);
    }


}