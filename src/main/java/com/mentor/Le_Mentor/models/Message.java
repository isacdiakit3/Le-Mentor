package com.mentor.Le_Mentor.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private String pieceJointe;
    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "mentorId" , nullable = true)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable = true)
    private Etudiant etudiant;

    @ManyToOne()
    @JoinColumn(name = "classeId" , nullable = true)
    private Classe classe;
}
