package com.mentor.Le_Mentor.models;
import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data

public class DemandeMentorat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status = "attente";
    private LocalDateTime date = LocalDateTime.now();
    
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "mentorId" , nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable= false)
    private Etudiant etudiant;
}
