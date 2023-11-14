package com.mentor.Le_Mentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.RenduDevoir;

@Repository
public interface RenduDevoirRepository extends JpaRepository<RenduDevoir, Long> {
    
}
