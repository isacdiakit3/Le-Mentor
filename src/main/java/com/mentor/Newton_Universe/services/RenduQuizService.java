package com.mentor.Newton_Universe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.mentor.Newton_Universe.models.RenduQuiz;
import com.mentor.Newton_Universe.repository.RenduQuizRepository;

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
            r.setPieceJointe(renduQuiz.getPieceJointe());
            r.setPoint(renduQuiz.getPoint());
            r.setDate(renduQuiz.getDate());
            return renduQuizRepository.save(r);
        }).orElseThrow(()-> new RuntimeException("Non trouvé"));
    }

    public String supprimer(Long id){
        renduQuizRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
