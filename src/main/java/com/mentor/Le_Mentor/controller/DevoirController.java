package com.mentor.Le_Mentor.controller;
import java.util.List;

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
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mentor.Le_Mentor.models.Devoir;
import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.services.DevoirService;

import jakarta.validation.Valid;

/**
 * DevoirController
 */
@RestController
@RequestMapping("devoir")
public class DevoirController {

    @Autowired
    private DevoirService devoirService;

    @PostMapping("creerDevoir")
    public ResponseEntity<Devoir> creer(
            @Valid @RequestParam("devoir") String dString,
            @RequestParam(value ="pieceJointe") MultipartFile multipartFile) throws Exception {

        Devoir devoir = new Devoir();
        try{
            JsonMapper jsonMapper = new JsonMapper();
            jsonMapper.registerModule(new JavaTimeModule());
            devoir = jsonMapper.readValue(dString, Devoir.class);
        }catch(JsonProcessingException e){
            throw new Exception(e.getMessage());
        }
        Devoir savedDevoir = devoirService.creer(devoir,multipartFile);

        return new ResponseEntity<>(savedDevoir, HttpStatus.CREATED);
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
