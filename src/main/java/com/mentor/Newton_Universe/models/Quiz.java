package com.mentor.Newton_Universe.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;
    private String question;
    private String reponse;
    private long point;
    private LocalDate date;
    private LocalDate dateLimite;

    @ManyToOne
    @JoinColumn(name = "MentorId" , nullable = false)
    private Mentor mentor;


}
