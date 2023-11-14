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
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "mentorId" , nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable = false)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "classeId" , nullable = false)
    private Classe classe;
}
