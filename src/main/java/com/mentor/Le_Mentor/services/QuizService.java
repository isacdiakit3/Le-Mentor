package com.mentor.Le_Mentor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.Quiz;
import com.mentor.Le_Mentor.repository.QuizRepository;

import java.util.List;

@Service
public class QuizService {
    
    @Autowired
    private QuizRepository quizRepository;


    public Quiz creer(Quiz quiz){
        return quizRepository.save(quiz);
    }

    public List<Quiz> lire(){
        return quizRepository.findAll();
    }

    public Quiz rechercher(Long id){
        return quizRepository.findById(id).get();
    }

    public Quiz modifier(Long id , Quiz quiz){
        return quizRepository.findById(id).map(q->{
            q.setTitre(quiz.getTitre());
            q.setDescription(quiz.getDescription());
            q.setQuestion(quiz.getQuestion());
            q.setReponse(quiz.getReponse());
            q.setDateLimite(quiz.getDateLimite());
            q.setPoint(quiz.getPoint());
            q.setDate(quiz.getDate());
            return quizRepository.save(q);
        }).orElseThrow(()-> new RuntimeException("quiz nontrouvé"));
    }

    public String supprimer(Long id){
        quizRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
