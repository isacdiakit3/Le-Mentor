package com.mentor.Le_Mentor.controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Le_Mentor.models.RenduDevoir;
import com.mentor.Le_Mentor.services.RenduDevoirService;

/**
 * RenduDevoirController
 */
@RestController
@RequestMapping("rendu_devoir")
public class RenduDevoirController {

    private RenduDevoirService renduDevoirService;

    @PostMapping("/creer")
    public RenduDevoir creer(@RequestBody RenduDevoir renduDevoir){
        return renduDevoirService.creer(renduDevoir);
    }

    @GetMapping("")
    public List<RenduDevoir> lire(){
        return renduDevoirService.lire();
    }

    @GetMapping("/{id}")
    public RenduDevoir rechercher(@PathVariable Long id){
        return renduDevoirService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public RenduDevoir modifier(@PathVariable Long id , @RequestBody RenduDevoir renduDevoir){
        return renduDevoirService.modifier(id, renduDevoir);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return renduDevoirService.supprimer(id);
    }
    
}