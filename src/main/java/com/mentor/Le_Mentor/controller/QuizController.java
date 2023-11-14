package com.mentor.Le_Mentor.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Le_Mentor.models.Quiz;
import com.mentor.Le_Mentor.services.QuizService;

/**
 * QuizController
 */
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/creer")
    public Quiz creer(@RequestBody Quiz quiz){
        return quizService.creer(quiz);
    }

    @GetMapping("")
    public List<Quiz> lire(){
        return quizService.lire();
    }

    @GetMapping("/{id}")
    public Quiz rechercher(@PathVariable Long id){
        return quizService.rechercher(id);
    }

    @PutMapping ("/modifier/{id}")
    public Quiz modifier(@PathVariable Long id , @RequestBody Quiz quiz){
        return quizService.modifier(id, quiz);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return quizService.supprimer(id);
    }
}