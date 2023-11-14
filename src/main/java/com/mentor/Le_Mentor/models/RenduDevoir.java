package com.mentor.Le_Mentor.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RenduDevoir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String pieceJointe;
    private long note = 0;
    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable = false)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "devoirId" , nullable = false)
    private Devoir devoir;

    
}