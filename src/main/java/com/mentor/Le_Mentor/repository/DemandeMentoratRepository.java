package com.mentor.Le_Mentor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.DemandeMentorat;

@Repository
public interface DemandeMentoratRepository extends JpaRepository<DemandeMentorat, Long> {
    
    List<DemandeMentorat> findByMentorIdAndStatusEquals(Long id , String status);
    DemandeMentorat findByStatusAndId(String status , Long id);
}
