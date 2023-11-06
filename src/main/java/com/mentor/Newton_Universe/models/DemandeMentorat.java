package com.mentor.Newton_Universe.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DemandeMentorat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private LocalDate date;
    
    @ManyToOne
    @JoinColumn(name = "mentorId" , nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable= false)
    private Etudiant etudiant;
}
