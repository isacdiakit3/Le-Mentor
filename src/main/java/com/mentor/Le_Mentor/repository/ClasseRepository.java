package com.mentor.Le_Mentor.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.Classe;

import java.util.*;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
    List<Classe> findByMentorId(Long id);
    Classe findClasseById(Long id);
}
