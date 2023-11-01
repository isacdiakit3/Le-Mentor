package com.mentor.Newton_Universe.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String prenom;
    private String nom;
    private String ville;
    private String email;
    private String password;
    @Lob
    private byte[] photo;
}
