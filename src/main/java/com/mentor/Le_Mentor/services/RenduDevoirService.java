package com.mentor.Le_Mentor.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.RenduDevoir;
import com.mentor.Le_Mentor.repository.RenduDevoirRepository;

import java.util.List;

@Service
public class RenduDevoirService {
    
    @Autowired
    private RenduDevoirRepository renduDevoirRepository;


    public RenduDevoir creer(RenduDevoir renduDevoir){
        return renduDevoirRepository.save(renduDevoir);
    }

    public List<RenduDevoir> lire(){
        return renduDevoirRepository.findAll();
    }

    public RenduDevoir rechercher(Long id){
        return renduDevoirRepository.findById(id).get();
    }

    public RenduDevoir modifier(Long id , RenduDevoir renduDevoir){
        return renduDevoirRepository.findById(id).map(r->{
            r.setTitre(renduDevoir.getTitre());
            r.setPieceJointe(renduDevoir.getPieceJointe());
            r.setDate(renduDevoir.getDate());
            return renduDevoirRepository.save(r);
        }).orElseThrow(()-> new RuntimeException("Non trouvé"));
    }

    public String supprimer(Long id){
        renduDevoirRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
