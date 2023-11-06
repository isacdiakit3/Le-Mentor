package com.mentor.Newton_Universe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Newton_Universe.models.Etudiant;
import com.mentor.Newton_Universe.models.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
        Mentor findByEmail(String email);

}
