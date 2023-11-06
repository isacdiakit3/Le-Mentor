package com.mentor.Newton_Universe.controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mentor.Newton_Universe.ApiResponse;
import com.mentor.Newton_Universe.models.Etudiant;
import com.mentor.Newton_Universe.services.EtudiantService;

@RestController
@RequestMapping("etudiant")
public class EtudiantController {
    private final EtudiantService etudiantService;

    private EtudiantController(EtudiantService etudiantService){
        this.etudiantService = etudiantService;
    }

    @PostMapping("/inscrire")
    public Etudiant inscrire(@RequestBody Etudiant etudiant){
        return etudiantService.inscrire(etudiant);
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
    public ApiResponse connexion(@RequestParam String email , String password){
        return etudiantService.login(email, password);
    }
}