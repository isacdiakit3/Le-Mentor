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

import com.mentor.Le_Mentor.models.Classe;
import com.mentor.Le_Mentor.services.ClasseService;

/**
 * ClasseController
 */
@RestController
@RequestMapping("classe")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @PostMapping("/creer")
    public Classe creer(@RequestBody Classe classe){
        return classeService.creer(classe);
    }

    @GetMapping("")
    public List<Classe> lire(){
        return classeService.lire();
    }

    @GetMapping("/{id}")
    public Classe rechercher(@PathVariable Long id ){
        return classeService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public Classe modifier(@PathVariable Long id , Classe classe){
        return classeService.modifier(id, classe);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return classeService.supprimer(id);
    }
}