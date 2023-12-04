package com.mentor.Le_Mentor.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.mentor.Le_Mentor.ApiResponse;
import com.mentor.Le_Mentor.models.Classe;
import com.mentor.Le_Mentor.models.DemandeMentorat;
import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.models.Mentor;
import com.mentor.Le_Mentor.services.MentorService;

import jakarta.validation.Valid;

/**
 * MentorController
 */
@RestController
@RequestMapping("mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @PostMapping("/inscrires")
    public ResponseEntity<Mentor> inscrire(
            @Valid @RequestParam("mentor") String mString,
            @RequestParam(value ="photo") MultipartFile multipartFile ,
            @RequestParam(value ="diplome") MultipartFile multipartFil) throws Exception {

        Mentor mentor = new Mentor();
        try{
            mentor = new JsonMapper().readValue(mString, Mentor.class);
        }catch(JsonProcessingException e){
            throw new Exception(e.getMessage());
        }
        
        Mentor savedMentor = mentorService.inscrire(mentor,multipartFile,multipartFil);

        return new ResponseEntity<>(savedMentor, HttpStatus.CREATED);
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
    public Optional<Mentor> connexion(@Valid @RequestBody Map<String, String> requestBody){
        String email = requestBody.get("email");
        String password = requestBody.get("password");
        return mentorService.connexion(email, password);
    }

    @GetMapping("/accepterListe/{id}")
    public List<DemandeMentorat> demandeAcceptee(@PathVariable Long id){
        return mentorService.getDemandeMentoratAcceptee(id);
    }

    @GetMapping("/attente/{id}")
    public List<DemandeMentorat> demandeAttente(@PathVariable Long id){
        return mentorService.getDemandeMentoratAttente(id);
    }

    @GetMapping("/classeMentor/{id}")
    public List<Classe> listeClasses(@PathVariable Long id){
        return mentorService.getClasse(id);
    }

    @PutMapping("/accepter/{id}")
    public String accepterDemande(@PathVariable Long id){
        return mentorService.accepterDemande(id);
    }

    @PutMapping("/refuser/{id}")
    public String refuserDemande(@PathVariable Long id){
        return mentorService.refuserDemande(id);
    }

    @PutMapping("/accepeterDemandeInscription/{id}")
    public String accepterDemandeInscription(@PathVariable Long id){
        return mentorService.accepterDemandeInscription(id);
    }
}