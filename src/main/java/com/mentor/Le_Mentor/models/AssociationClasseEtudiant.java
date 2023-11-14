package com.mentor.Le_Mentor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class AssociationClasseEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classeId" , nullable = false)
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "etudiantId" , nullable = false)
    private Etudiant etudiant;
}