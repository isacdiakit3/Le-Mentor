package com.mentor.Le_Mentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.Devoir;

@Repository
public interface DevoirRepository  extends JpaRepository<Devoir, Long>{
    Devoir findByTitre(String titre);
}
