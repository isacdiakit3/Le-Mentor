package com.mentor.Le_Mentor.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classe {

    private static final String[] IMAGES = {
        "livre_telephone.svg",
        "rose_telephone.svg"
    };


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String filiere;
    @Column(nullable = false)
    private String salle;
    private long effectif = 0;
    private String image;
    
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "mentorId" , nullable = false)
    private Mentor mentor;

    // @ManyToOne
    // @JoinColumn(name = "adminId" , nullable = true)
    // private Admin admin;

    @OneToMany(mappedBy = "classe" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<AssociationClasseEtudiant> associationClasseEtudiants = new ArrayList<>();

    @OneToMany(mappedBy = "classe" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "classe" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Devoir> devoirs = new ArrayList<>();

    @OneToMany(mappedBy = "classe" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Quiz> quizs = new ArrayList<>();

    public Classe (){
        Random random = new Random();
        this.image = IMAGES[random.nextInt(IMAGES.length)];
    }
}
