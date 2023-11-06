package com.mentor.Newton_Universe.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String filiere;
    private String salle;
    private long effectif;
    private String image;
    
    @ManyToOne
    @JoinColumn(name = "mentorId" , nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "EtudiantId" , nullable = false)
    private Etudiant etudiant;

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Devoir> devoirs = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Quiz> quizs = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<RenduDevoir> renduDevoirs = new ArrayList<>();

    @OneToMany(mappedBy = "mentor" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<RenduQuiz> renduQuizs = new ArrayList<>();
}
