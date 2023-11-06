package com.mentor.Newton_Universe.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String prenom;
    private String nom;
    private String ville;
    private String email;
    private String password;
    private String photo;

    @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<DemandeMentorat> demandeMentorats = new ArrayList<>();

    @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Classe> classes = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Etudiant> etudiants = new ArrayList<>();
    
}
