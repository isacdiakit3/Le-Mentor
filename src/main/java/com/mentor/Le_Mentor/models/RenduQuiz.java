package com.mentor.Le_Mentor.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class RenduQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String[] reponse ;
    private long note = 0;
    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable = false)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "quizId" , nullable = false)
    private Quiz quiz;
}
