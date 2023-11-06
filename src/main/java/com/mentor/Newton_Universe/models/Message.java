package com.mentor.Newton_Universe.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Message {
    private Long id;
    private String contenu;
    private String pieceJointe;
    private LocalDate date;

    // @ManyToOne
    // @JoinColumn(name = "eentorId" , nullable = false)
    // private Mentor mentor;

    // @ManyToOne
    // @JoinColumn(name = "etudiantId" , nullable = false)
    // private Etudiant etudiant;

    // @ManyToOne
    // @JoinColumn(name = "classeId" , nullable = false)
    // private Classe classe;
}
