package com.mentor.Newton_Universe.repository;
import com.mentor.Newton_Universe.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
