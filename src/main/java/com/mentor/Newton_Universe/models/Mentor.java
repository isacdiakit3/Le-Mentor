package com.mentor.Newton_Universe.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String prenom;
    private String nom;
    private String ville;
    private String qualification;
    private String diplome;
    private String email;
    private String password;
    private String photo;
    private long certificat;
    private boolean approuvee;

    @OneToMany(mappedBy = "mentor" , cascade= CascadeType.ALL , orphanRemoval = true)
    private List<DemandeMentorat> demandeMentorats = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Classe> classes = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Devoir> devoirs = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Quiz> quizs = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

}
