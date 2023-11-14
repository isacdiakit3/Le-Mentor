package com.mentor.Le_Mentor.controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Le_Mentor.models.RenduQuiz;
import com.mentor.Le_Mentor.services.RenduQuizService;

/**
 * RenduQuizController
 */
@RestController
@RequestMapping("rendu_quiz")
public class RenduQuizController {

    private RenduQuizService renduQuizService;

    @PostMapping("/creer")
    public RenduQuiz creer(@RequestBody RenduQuiz renduQuiz){
        return renduQuizService.creer(renduQuiz);
    }

    @GetMapping("")
    public List<RenduQuiz> lire(){
        return renduQuizService.lire();
    }

    @GetMapping("/{id}")
    public RenduQuiz rechercher(@PathVariable Long id){
        return renduQuizService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public RenduQuiz modifier(@PathVariable Long id , @RequestBody RenduQuiz renduQuiz){
        return renduQuizService.modifier(id, renduQuiz);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return renduQuizService.supprimer(id);
    }
}