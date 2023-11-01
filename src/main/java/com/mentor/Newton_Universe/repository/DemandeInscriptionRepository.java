package com.mentor.Newton_Universe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Newton_Universe.models.DemandeInscription;


@Repository
public interface DemandeInscriptionRepository extends JpaRepository<DemandeInscription, Long>{

    
}