package com.mentor.Le_Mentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByEmail(String email);
    
}