package com.mentor.Le_Mentor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.AssociationClasseEtudiant;

@Repository
public interface AssociationClasseEtudiantRepository extends JpaRepository<AssociationClasseEtudiant , Long>{
    List<AssociationClasseEtudiant> findByClasseId(Long id);
    
}
