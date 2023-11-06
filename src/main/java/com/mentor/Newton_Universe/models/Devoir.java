package com.mentor.Newton_Universe.models;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Devoir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;
    private String pieceJointe;
    private long point;
    private LocalDate date;
    private LocalDate dateLimite;

    @ManyToOne
    @JoinColumn(name = "MentorId" , nullable = false)
    private Mentor mentor;
}
