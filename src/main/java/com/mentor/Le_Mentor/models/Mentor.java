package com.mentor.Le_Mentor.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @Column(nullable = true)
    private long certificat;
    @Column(columnDefinition = "boolean default false")
    private boolean approuvee;

    @OneToMany(mappedBy = "mentor" , cascade= CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<DemandeMentorat> demandeMentorats = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Classe> classes = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Devoir> devoirs = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Quiz> quizs = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Message> messages = new ArrayList<>();

}
