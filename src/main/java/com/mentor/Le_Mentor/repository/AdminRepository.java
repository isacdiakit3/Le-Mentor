package com.mentor.Le_Mentor.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
        Admin findByEmail(String email);

}
