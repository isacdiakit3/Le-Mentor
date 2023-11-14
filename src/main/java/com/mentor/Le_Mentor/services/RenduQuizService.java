package com.mentor.Le_Mentor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.RenduQuiz;
import com.mentor.Le_Mentor.repository.RenduQuizRepository;

import java.util.List;

@Service
public class RenduQuizService {
    

    @Autowired
    private RenduQuizRepository renduQuizRepository;

    public RenduQuiz creer(RenduQuiz renduQuiz){
        return renduQuizRepository.save(renduQuiz);
    }

    public List<RenduQuiz> lire(){
        return renduQuizRepository.findAll();
    }

    public RenduQuiz rechercher(Long id){
        return renduQuizRepository.findById(id).get();
    }

    public RenduQuiz modifier(Long id , RenduQuiz renduQuiz){
        return renduQuizRepository.findById(id).map(r->{
            r.setTitre(renduQuiz.getTitre());
            r.setReponse(renduQuiz.getReponse());
            r.setDate(renduQuiz.getDate());
            return renduQuizRepository.save(r);
        }).orElseThrow(()-> new RuntimeException("Non trouvé"));
    }

    public String supprimer(Long id){
        renduQuizRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
