package com.mentor.Le_Mentor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.services.AssociationClasseEtudiantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("associationClasseEtudiant/")
public class AssociationClasseEtudiantController {

    @Autowired
    private AssociationClasseEtudiantService associationClasseEtudiantService;
    
    @PostMapping("ajouterEtudiant/{idClasse}")
    public String ajouterEtudiant(@PathVariable Long classeId , @RequestBody List<Etudiant> etudiants ) throws Exception{
        return associationClasseEtudiantService.ajouterEtudiant(classeId, etudiants);
    }

    @GetMapping(value="participants")
    public List<Etudiant> getEtudiants(@PathVariable Long idClasse) {
        return associationClasseEtudiantService.getEtudiants(idClasse);
    }
    
}
