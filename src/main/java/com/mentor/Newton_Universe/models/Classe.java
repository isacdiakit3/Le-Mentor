package com.mentor.Newton_Universe.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String filiere;
    private String salle;
    private long effectif;
    private String image;
    
}
