package com.mentor.Le_Mentor.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String prenom;
    private String nom;
    private String pseudo;
    private String email;
    private String password;

    // @OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL , orphanRemoval = true)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // private List<Mentor> mentors;

    // @OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<Classe> classes = new ArrayList<>();

    // @OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<Devoir> devoirs = new ArrayList<>();

    // @OneToMany (mappedBy = "admin" , cascade = CascadeType.ALL , orphanRemoval = true)
    // private List<Quiz> quizs = new ArrayList<>();
}