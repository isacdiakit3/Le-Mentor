package com.mentor.Le_Mentor.models;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String destinateur;
    private String contenu;
    private LocalDate date;
    private boolean etat;

    @ManyToOne
    @JoinColumn(name = "mentorId" , nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable = false)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "adminId" , nullable = false)
    private Admin admin;

}
