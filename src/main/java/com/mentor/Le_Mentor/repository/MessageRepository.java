package com.mentor.Le_Mentor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.Le_Mentor.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message , Long>{
    List<Message> findByClasseId(Long id);
}
