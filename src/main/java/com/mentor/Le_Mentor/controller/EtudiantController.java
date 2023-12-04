package com.mentor.Le_Mentor.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.services.EtudiantService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private final EtudiantService etudiantService;

    private EtudiantController(EtudiantService etudiantService){
        this.etudiantService = etudiantService;
    }

    @PostMapping("/inscrires")
    public ResponseEntity<Etudiant> inscrire(
            @Valid @RequestParam("etudiant") String etuString,
            @RequestParam(value ="photo") MultipartFile multipartFile) throws Exception {

        Etudiant etudiant = new Etudiant();
        try{
            etudiant = new JsonMapper().readValue(etuString, Etudiant.class);
        }catch(JsonProcessingException e){
            throw new Exception(e.getMessage());
        }
        Etudiant savedEtudiant = etudiantService.inscrire(etudiant,multipartFile);

        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Etudiant> lire(){
        return etudiantService.lire();
    }

    @GetMapping("/{id}")
    public Etudiant rechercher(@PathVariable Long id){
        return etudiantService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public Etudiant modifier(@PathVariable Long id , @RequestBody Etudiant etudiant){
        return etudiantService.modifier(id, etudiant);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return etudiantService.supprimer(id);
    }

    @PostMapping("/connexion")
    public Optional<Etudiant> connexion(@Valid @RequestBody Map<String, String> requestBody){
        String email = requestBody.get("email");
        String password = requestBody.get("password");
        return etudiantService.connexion(email, password);
    }
}