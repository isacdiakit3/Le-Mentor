package com.mentor.Newton_Universe.models;
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
    private long point;
    private LocalDate date;
}
