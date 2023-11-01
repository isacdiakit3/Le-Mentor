package com.mentor.Newton_Universe.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String prenom;
    private String nom;
    private String ville;
    private String qualification;
    private String diplome;
    private String email;
    private String password;
    private String photo;
    private long certificat;
    private boolean approuvee;

}
