package com.mentor.Le_Mentor.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private String photo ;


    // @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // private List<DemandeMentorat> demandeMentorats = new ArrayList<>();

    // @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<AssociationClasseEtudiant> associationClasseEtudiants = new ArrayList<>();

    // @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<Message> messages = new ArrayList<>();

    // @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<Notification> notifications = new ArrayList<>();

    // @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<RenduDevoir> renduDevoirs = new ArrayList<>();

    // @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<RenduQuiz> renduQuizs = new ArrayList<>();


}
