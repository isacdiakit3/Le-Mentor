package com.mentor.Le_Mentor.models;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Devoir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    @Column(nullable = true)
    private String description;
    private String pieceJointe;
    private long point;
    private LocalDate date;
    @Column(nullable = true)
    private LocalDate dateLimite;

    @ManyToOne
    @JoinColumn(name = "MentorId" , nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "ClasseId" , nullable = false)
    private Classe classe;

    

    @OneToMany(mappedBy = "devoir" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<RenduDevoir> renduDevoirs = new ArrayList<>();
}
