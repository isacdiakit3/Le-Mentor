package com.mentor.Newton_Universe.models;
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

}
