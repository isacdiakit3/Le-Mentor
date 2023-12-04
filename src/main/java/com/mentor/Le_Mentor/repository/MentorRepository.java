package com.mentor.Le_Mentor.repository;
import java.util.*;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.models.Mentor;



@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
        Mentor findByEmail(String email);
        Mentor findByApprouveeAndId(boolean approuvee, long id);
        Optional<Mentor> findByEmailAndPassword(String email, String password);

}
