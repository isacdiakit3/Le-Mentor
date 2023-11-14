package com.mentor.Le_Mentor.models;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    @Column(nullable= true)
    private String description;
    private String question;
    private String[] reponse;
    private long point;
    private LocalDate date = LocalDate.now();
    @Column(nullable= true)
    private LocalDate dateLimite;

    @ManyToOne
    @JoinColumn(name = "mentorId" , nullable = false)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "classeId" , nullable = false)
    private Classe classe;

    

    @OneToMany
    @JoinColumn(name = "quiz" , nullable = false)
    private List<RenduQuiz> renduQuizs = new ArrayList<>();


}
